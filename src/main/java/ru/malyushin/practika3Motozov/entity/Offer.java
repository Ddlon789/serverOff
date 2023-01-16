package ru.malyushin.practika3Motozov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private UUID id;
    @Column(name = "serial_number")
    @JsonProperty("serial_number")
    private String serialNumber;
    @Column(name = "sign_date")
    @JsonProperty("sign_date")
    private LocalDate signingDate;
    @Column(name = "ending_date")
    @JsonProperty("ending_date")
    private LocalDate endingDate;
    @Column(name = "start_date")
    @JsonProperty("start_date")
    private LocalDate startDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stuff")
    @JsonProperty("stuff")
    private Stuff stuff;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="office")
    @JsonProperty("office")
    private Office office;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client")
    @JsonProperty("client")
    private Client client;

    public Offer() {}

    public Offer(String serialNumber, LocalDate signingDate, LocalDate endingDate, LocalDate startDate, Stuff stuff, Office office, Client client) {
        this.serialNumber = serialNumber;
        this.signingDate = signingDate;
        this.endingDate = endingDate;
        this.startDate = startDate;
        this.stuff = stuff;
        this.office = office;
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(LocalDate signingDate) {
        this.signingDate = signingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
