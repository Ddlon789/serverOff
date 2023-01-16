package ru.malyushin.practika3Motozov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import javax.management.MXBean;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class NewOfferParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @Column(name = "client_id")
    @JsonProperty("client_id")
    private UUID clientId;
    @Column(name = "stuff_id")
    @JsonProperty("stuff_id")
    private UUID stuffId;
    @Column(name = "start_date")
    @JsonProperty("start_date")
    private LocalDate startDate;
    @Column(name = "ending_date")
    @JsonProperty("ending_date")
    private LocalDate endingDate;

    public NewOfferParameters() {}

    public NewOfferParameters(UUID clientId, UUID stuffId, LocalDate startDate, LocalDate endingDate) {
        this.clientId = clientId;
        this.stuffId = stuffId;
        this.startDate = startDate;
        this.endingDate = endingDate;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getStuffId() {
        return stuffId;
    }

    public void setStuffId(UUID stuffId) {
        this.stuffId = stuffId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }
}
