package ru.malyushin.practika3Motozov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.malyushin.practika3Motozov.exceptions.AppError;
import ru.malyushin.practika3Motozov.entity.Office;
import ru.malyushin.practika3Motozov.services.OfficeService;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping()
    public ResponseEntity<?> findAllOffices() {
        try {
            return ResponseEntity.ok(officeService.findAllOffice());
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOfficeById(@PathVariable("id") UUID id) {
        try {
            Office office = officeService.findOfficeById(id);
            return new ResponseEntity<>(office, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Office with id: " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }
}
