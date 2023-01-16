package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.dto.OfferStatistic;
import ru.malyushin.practika3Motozov.entity.Client;
import ru.malyushin.practika3Motozov.entity.NewOfferParameters;
import ru.malyushin.practika3Motozov.entity.Offer;
import ru.malyushin.practika3Motozov.entity.Stuff;
//import ru.malyushin.practika3Motozov.model.OfferStatisticModel;
import ru.malyushin.practika3Motozov.repository.ClientRepo;
import ru.malyushin.practika3Motozov.repository.OfferRepo;
import ru.malyushin.practika3Motozov.repository.StuffRepo;

import java.time.LocalDate;
import java.util.*;

@Service
public class NewOfferService {

    @Autowired
    private StuffRepo stuffRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private OfferRepo offerRepo;

    public void toOffer(NewOfferParameters newOfferParameters) {
        Offer offer = new Offer();
        LeasingOfferService leasingOfferService = new LeasingOfferService();
        offer.setSerialNumber(leasingOfferService.generateSerialNumber());
        offer.setStartDate(newOfferParameters.getStartDate());
        offer.setEndingDate(newOfferParameters.getEndingDate());
        offer.setSigningDate(LocalDate.now());
        offer.setStartDate(newOfferParameters.getStartDate());
        offer.setEndingDate(newOfferParameters.getEndingDate());
        offer.setStuff(stuffRepo.findStuffById(newOfferParameters.getStuffId()));
        offer.setClient(clientRepo.findClientById(newOfferParameters.getClientId()));
        offer.setOffice(leasingOfferService.getOffice());
        offerRepo.save(offer);
    }

    public Map<String, Integer> getMapOfStuffsAndOffers() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Stuff> stuffs = stuffRepo.findAll();
        List<Offer> offers = offerRepo.findAll();
        for (Stuff stuff: stuffs) {
            int stuffCount = 0;
            map.put(stuff.getName(), stuffCount);
            for (Offer offer: offers) {
                if (offer.getStuff() == null)
                    continue;
                if (stuff.getId().equals(offer.getStuff().getId()))
                    map.replace(stuff.getName(), stuffCount++);
            }
        }
        return map;
    }

    public Map<String, Integer> getMapOfClientsAndOffers() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Client> clients = clientRepo.findAll();
        List<Offer> offers = offerRepo.findAll();
        for (Client client: clients) {
            int clientCount = 0;
            map.put(client.getName(), clientCount);
            for (Offer offer: offers) {
                if (offer.getClient() == null)
                    continue;
                if (client.getId().equals(offer.getClient().getId()))
                    map.replace(client.getName(), clientCount++);
            }
        }
        return map;
    }

    public Set<String> getSurnamesOfClient() {
        Set<String> surnames = new HashSet<String>();
        clientRepo.findAll()
                .stream()
                .forEach(client -> surnames
                        .add(client.getSurname()));
        return surnames;
    }

    public OfferStatistic getOfferStatistic() {
        OfferStatistic offerStatistic = new OfferStatistic();
        offerStatistic.setStuffStatistic(getMapOfStuffsAndOffers());
        offerStatistic.setClientsStatistic(getMapOfClientsAndOffers());
        offerStatistic.setClientSurnames(getSurnamesOfClient());
        return offerStatistic;
    }
}
