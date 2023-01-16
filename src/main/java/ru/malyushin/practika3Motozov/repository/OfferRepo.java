package ru.malyushin.practika3Motozov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.malyushin.practika3Motozov.entity.Offer;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepo extends CrudRepository<Offer, UUID> {
    List<Offer> findAll();
    Offer findOfferById(UUID id);
}
