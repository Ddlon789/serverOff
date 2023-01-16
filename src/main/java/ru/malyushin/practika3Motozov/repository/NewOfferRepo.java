package ru.malyushin.practika3Motozov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.malyushin.practika3Motozov.entity.NewOfferParameters;

import java.util.UUID;

@Repository
public interface NewOfferRepo extends CrudRepository<NewOfferParameters, UUID> {
}
