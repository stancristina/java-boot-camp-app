package com.adobe.devcamp.controller;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.GenericService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.prism.ps.PPSBlend_LIGHTENPeer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class AdvertiserController {
    private final GenericService<Campaign> campaignGenericService;
    private final GenericService<Advertiser> advertiserGenericService;
    private final GenericService<Publisher> publisherGenericService;
    private final GenericService<User> userGenericService;

    public AdvertiserController(GenericService<Campaign> campaignGenericService, GenericService<Advertiser> advertiserGenericService, GenericService<Publisher> publisherGenericService, GenericService<User> userGenericService) {
        this.campaignGenericService = campaignGenericService;
        this.advertiserGenericService = advertiserGenericService;
        this.publisherGenericService = publisherGenericService;
        this.userGenericService = userGenericService;
    }

    @GetMapping(path = "/campaigns", produces = MediaType.APPLICATION_JSON_VALUE, params = "advertiserId")
    public List<Campaign> getAllActiveCampaigns(@RequestParam(name = "advertiserId") Integer advertiserId){
        List<Campaign> activeCampaigns =  new ArrayList<Campaign>(campaignGenericService.getAll(Campaign.class).values());
        return activeCampaigns.stream()
                .filter(campaign -> campaign.getAdvertiserId().intValue() == advertiserId.intValue())
                .filter(campaign -> campaign.getEndTime() > System.currentTimeMillis())
                .filter(campaign -> campaign.getStartTime() < System.currentTimeMillis())
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/advertisers/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getTargetedUsers(@RequestParam(name = "advertiserId") Integer advertiserId,
                                       @RequestParam(name = "campaignId") Integer campaignId) {

        final Campaign campaign = campaignGenericService.getById(Campaign.class, campaignId);
        final Advertiser advertiser = advertiserGenericService.getById(Advertiser.class, advertiserId);

        final List<Publisher> publishers = advertiser.getPublishers().stream()
                .map(publisherId -> publisherGenericService.getById(Publisher.class, publisherId))
                .collect(Collectors.toList());

        return publishers.stream()
                .map(publisher -> getTargetedUsersFor(publisher, campaign))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<User> getTargetedUsersFor(Publisher publisher, Campaign campaign) {
        final List<User> users = publisher.getUsers().stream()
                .map(userId -> userGenericService.getById(User.class, userId))
                .collect(Collectors.toList());
        return users.stream()
                .filter(user -> user.getProfile().getGender() == campaign.getTarget().getGender())
                //to do filter by age and domains
//                .filter(user ->
//                        Year.now().getValue() - user.getProfile().getDateOfBirth().getYear() >= campaign.getTarget().minAge
//                        && Year.now().getValue() - user.getProfile().getDateOfBirth().getYear() <= campaign.getTarget().maxAge)
                //.filter(user -> user.getProfile().getInterests().)
                .collect(Collectors.toList());
    }
}
