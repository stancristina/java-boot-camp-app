package com.adobe.devcamp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Publisher {
    private final String name;
    private final Set<Domain> domains;
    private final List<Integer> advertisers;
    private final List<Integer> users;

    @JsonCreator
    public Publisher(@JsonProperty("name") String name,
                     @JsonProperty("domains") Set<Domain> domains,
                     @JsonProperty("advertisers") List<Integer> advertisers,
                     @JsonProperty("users") List<Integer> users) {
        this.name = name;
        this.domains = domains;
        this.advertisers = advertisers;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public List<Integer> getAdvertisers() {
        return advertisers;
    }

    public List<Integer> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getDomains(), publisher.getDomains()) &&
                Objects.equals(getAdvertisers(), publisher.getAdvertisers()) &&
                Objects.equals(getUsers(), publisher.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDomains(), getAdvertisers(), getUsers());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", domains=" + domains +
                ", advertisers=" + advertisers +
                ", users=" + users +
                '}';
    }
}
