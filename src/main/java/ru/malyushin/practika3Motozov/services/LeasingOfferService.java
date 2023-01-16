package ru.malyushin.practika3Motozov.services;

import ru.malyushin.practika3Motozov.repository.OfferService;
import ru.malyushin.practika3Motozov.entity.Client;
import ru.malyushin.practika3Motozov.entity.Offer;
import ru.malyushin.practika3Motozov.entity.Office;
import ru.malyushin.practika3Motozov.entity.Stuff;

import java.time.LocalDate;
import java.util.UUID;

public class LeasingOfferService implements OfferService {
    private final Office office = new Office("Murmansk, Kolskaya, 67", "Murmansk, Kolskaya, 67", 23);
    public String generateSerialNumber() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
        return null;
    }

    public Office getOffice() {
        return office;
    }
}
