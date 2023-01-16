package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.entity.Position;
import ru.malyushin.practika3Motozov.repository.PositionRepo;

import java.util.List;
import java.util.UUID;

@Service
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public List<Position> findAllPositions() {
        return positionRepo.findAll();
    }

    public Position findPosition(UUID id) {
        if (positionRepo.findPositionById(id) == null)
            throw new NullPointerException();
        return positionRepo.findPositionById(id);
    }
}
