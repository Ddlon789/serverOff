package ru.malyushin.practika3Motozov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.malyushin.practika3Motozov.entity.Office;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfficeRepo extends CrudRepository<Office, UUID> {
    List<Office> findAll();
    Office findOfficeById(UUID id);
}
