package ru.malyushin.practika3Motozov.repository;

import ru.malyushin.practika3Motozov.entity.Client;
import ru.malyushin.practika3Motozov.entity.Offer;
import ru.malyushin.practika3Motozov.entity.Stuff;

import java.time.LocalDate;

public interface OfferService {
    public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff);
}
