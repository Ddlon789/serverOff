package ru.malyushin.practika3Motozov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.malyushin.practika3Motozov.exceptions.AppError;
import ru.malyushin.practika3Motozov.entity.Position;
import ru.malyushin.practika3Motozov.services.PositionService;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public ResponseEntity<?> findAllPosition() {
        try {
            return ResponseEntity.ok(positionService.findAllPositions());
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPositionById(@PathVariable("id") UUID id) {
        try {
            Position position = positionService.findPosition(id);
            return new ResponseEntity<>(position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Position with id: " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }
}

