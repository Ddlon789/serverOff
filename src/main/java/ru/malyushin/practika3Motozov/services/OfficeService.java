package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.entity.Office;
import ru.malyushin.practika3Motozov.repository.OfficeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepo officeRepo;

    public List<Office> findAllOffice() {
        return officeRepo.findAll();
    }

    public Office findOfficeById(UUID id) {
        if (officeRepo.findOfficeById(id) == null)
            throw new NullPointerException();
        return officeRepo.findOfficeById(id);
    }
}
