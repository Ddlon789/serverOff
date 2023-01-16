package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.entity.Offer;
import ru.malyushin.practika3Motozov.repository.OfferRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OfferServices {
    @Autowired
    private OfferRepo offerRepo;

    public List<Offer> findAllOffers() {
        return offerRepo.findAll();
    }

    public Offer findOfferById(UUID id) {
        if (offerRepo.findOfferById(id) == null)
            throw new NullPointerException();
        return offerRepo.findOfferById(id);
    }
}
