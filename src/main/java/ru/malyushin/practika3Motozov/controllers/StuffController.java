package ru.malyushin.practika3Motozov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.malyushin.practika3Motozov.exceptions.AppError;
import ru.malyushin.practika3Motozov.entity.Stuff;
import ru.malyushin.practika3Motozov.services.StuffService;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/stuff")
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @GetMapping()
    public ResponseEntity<?> findAllStuffs() {
        try {
            return ResponseEntity.ok(stuffService.getAllStuffs());
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStuffById(@PathVariable("id") UUID id) {
        try {
            Stuff stuff = stuffService.findStuffById(id);
            return new ResponseEntity<>(stuff, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Stuff with id: " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> postStuff(@RequestBody Stuff stuff) {
        try {
            stuffService.saveStuff(stuff);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
