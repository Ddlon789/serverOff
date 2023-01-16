package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.entity.Stuff;
import ru.malyushin.practika3Motozov.repository.StuffRepo;

import java.util.List;
import java.util.UUID;

@Service
public class StuffService {

    @Autowired
    private StuffRepo stuffRepo;

    public List<Stuff> getAllStuffs() {
        return stuffRepo.findAll();
    }

    public Stuff findStuffById(UUID id) {
        if (stuffRepo.findStuffById(id) == null)
            throw new NullPointerException();
        return stuffRepo.findStuffById(id);
    }

    public void saveStuff(Stuff stuff) {
        stuffRepo.save(stuff);
    }
}
