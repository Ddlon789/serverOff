package ru.malyushin.practika3Motozov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malyushin.practika3Motozov.entity.Client;
import ru.malyushin.practika3Motozov.repository.ClientRepo;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public void sendOneClient(Client client) throws Exception {
        if (clientRepo.findClientByInn(client.getInn()) != null)
            throw new Exception("User already in");
        clientRepo.save(client);
    }

    public Client getClient(UUID id) {
        if (clientRepo.findClientById(id) == null)
            throw new NullPointerException();
        return clientRepo.findClientById(id);
    }
}
