package com.adobe.devcamp.controller;

import com.adobe.devcamp.model.*;
import com.adobe.devcamp.service.GenericService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final GenericService<User> userService;
    private final GenericService<Advertiser> advertiserGenericService;
    private final GenericService<Campaign> campaignGenericService;
    private final GenericService<Publisher> publisherGenericService;

    public UserController(GenericService<User> userService, GenericService<Advertiser> advertiserGenericService, GenericService<Campaign> campaignGenericService, GenericService<Publisher> publisherGenericService) {
        this.userService = userService;
        this.advertiserGenericService = advertiserGenericService;
        this.campaignGenericService = campaignGenericService;
        this.publisherGenericService = publisherGenericService;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return new ArrayList<>(userService.getAll(User.class).values());
    }
}



