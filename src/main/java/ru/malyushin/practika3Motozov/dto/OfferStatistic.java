package ru.malyushin.practika3Motozov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfferStatistic {
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("stuff_statistics")
    private Map<String, Integer> stuffStatistic;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonProperty("client_statistics")
    private Map<String, Integer> clientsStatistic;
    @JsonProperty("client_surnames")
    private Set<String> clientSurnames;

    public OfferStatistic() {}

    public OfferStatistic(Map<String, Integer> stuffStatistic, Map<String, Integer> clientsStatistic, Set<String> clientSurnames) {
        this.stuffStatistic = stuffStatistic;
        this.clientsStatistic = clientsStatistic;
        this.clientSurnames = clientSurnames;
    }

    public Map<String, Integer> getStuffStatistic() {
        return stuffStatistic;
    }

    public void setStuffStatistic(Map<String, Integer> stuffStatistic) {
        this.stuffStatistic = stuffStatistic;
    }

    public Map<String, Integer> getClientsStatistic() {
        return clientsStatistic;
    }

    public void setClientsStatistic(Map<String, Integer> clientsStatistic) {
        this.clientsStatistic = clientsStatistic;
    }

    public Set<String> getClientSurnames() {
        return clientSurnames;
    }

    public void setClientSurnames(Set<String> clientSurnames) {
        this.clientSurnames = clientSurnames;
    }
}
