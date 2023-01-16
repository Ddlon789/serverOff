package ru.malyushin.practika3Motozov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.malyushin.practika3Motozov.exceptions.AppError;
import ru.malyushin.practika3Motozov.entity.Client;
import ru.malyushin.practika3Motozov.services.ClientService;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<?> getAllClients() {
        try {
            return ResponseEntity.ok(clientService.getAllClients());
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") UUID id) {
        try {
            Client client = clientService.getClient(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Client with id: " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> sendOneClient(@RequestBody Client client) {
        try {
            clientService.sendOneClient(client);
            return ResponseEntity.ok("Succesfull");
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
