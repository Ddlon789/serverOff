package ru.malyushin.practika3Motozov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("address")
    private String address;
    @Column(name = "law_address")
    @JsonProperty("law_address")
    private String lawAddress;
    @Column(name = "cabinets_count")
    @JsonProperty("cabinets_count")
    private Integer cabinetsCount;

    public Office() {}

    public Office(String address, String lawAddress, Integer cabinetsCount) {
        this.address = address;
        this.lawAddress = lawAddress;
        this.cabinetsCount = cabinetsCount;
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawAddress() {
        return lawAddress;
    }

    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    public Integer getCabinetsCount() {
        return cabinetsCount;
    }

    public void setCabinetsCount(Integer cabinetsCount) {
        this.cabinetsCount = cabinetsCount;
    }
}
