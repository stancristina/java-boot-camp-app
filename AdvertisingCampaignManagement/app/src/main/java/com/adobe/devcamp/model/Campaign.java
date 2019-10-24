package com.adobe.devcamp.model;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

public final class Campaign {
    private final String name;
    private final long startTime;
    private final long endTime;
    private final Integer  advertiserId;
    private final Target target;

    public Campaign(String name, long startTime, long endTime, Integer advertiserId, Target target) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.advertiserId = advertiserId;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Integer getAdvertiserId() {
        return advertiserId;
    }

    public Target getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return getStartTime() == campaign.getStartTime() &&
                getEndTime() == campaign.getEndTime() &&
                Objects.equals(getName(), campaign.getName()) &&
                Objects.equals(getAdvertiserId(), campaign.getAdvertiserId()) &&
                Objects.equals(getTarget(), campaign.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartTime(), getEndTime(), getAdvertiserId(), getTarget());
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", advertiserId=" + advertiserId +
                ", target=" + target +
                '}';
    }

    public final static class Target {
        public final Gender gender;
        public final short minAge;
        public final short maxAge;
        public final List<Domain> interests;

        public Target(Gender gender, short minAge, short maxAge, List<Domain> interests) {
            this.gender = gender;
            this.minAge = minAge;
            this.maxAge = maxAge;
            this.interests = interests;
        }

        public Gender getGender() {
            return gender;
        }

        public short getMinAge() {
            return minAge;
        }

        public short getMaxAge() {
            return maxAge;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return getMinAge() == target.getMinAge() &&
                    getMaxAge() == target.getMaxAge() &&
                    getGender() == target.getGender() &&
                    Objects.equals(getInterests(), target.getInterests());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGender(), getMinAge(), getMaxAge(), getInterests());
        }

        @Override
        public String toString() {
            return "Target{" +
                    "gender=" + gender +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    ", interests=" + interests +
                    '}';
        }
    }
}
