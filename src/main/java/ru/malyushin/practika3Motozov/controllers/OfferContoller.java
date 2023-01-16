package ru.malyushin.practika3Motozov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.malyushin.practika3Motozov.dto.OfferStatistic;
import ru.malyushin.practika3Motozov.entity.NewOfferParameters;
import ru.malyushin.practika3Motozov.exceptions.AppError;
import ru.malyushin.practika3Motozov.entity.Offer;
import ru.malyushin.practika3Motozov.services.NewOfferService;
import ru.malyushin.practika3Motozov.services.OfferServices;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/offer")
public class OfferContoller {

    @Autowired
    private OfferServices offerServices;

    @Autowired
    private NewOfferService newOfferService;

    @GetMapping()
    public ResponseEntity<?> getAllOffers() {
        try {
            return ResponseEntity.ok(offerServices.findAllOffers());
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOffer(@PathVariable("id") UUID id) {
        try {
            Offer offer = offerServices.findOfferById(id);
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Offer with id: " + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<?> getNewOffer(@RequestBody NewOfferParameters newOfferParameters) {
        try {
            newOfferService.toOffer(newOfferParameters);
            return new ResponseEntity<>(new AppError(200, "Ok"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/statistic")
    public ResponseEntity<?> getStatistic() {
        try {
            return new ResponseEntity<>(newOfferService.getOfferStatistic(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
