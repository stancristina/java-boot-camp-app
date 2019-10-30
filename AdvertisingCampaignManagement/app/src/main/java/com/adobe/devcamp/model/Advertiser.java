package com.adobe.devcamp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public final class Advertiser {
    private final String name;
    private final List<Integer> publishers;

    @JsonCreator
    public Advertiser(@JsonProperty("name") String name,
                      @JsonProperty("publishers") List<Integer> publishers) {
        this.name = name;
        this.publishers = publishers;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPublishers() {
        return publishers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Advertiser that = (Advertiser) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPublishers(), that.getPublishers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPublishers());
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "name='" + name + '\'' +
                ", publishers=" + publishers +
                '}';
    }
}
