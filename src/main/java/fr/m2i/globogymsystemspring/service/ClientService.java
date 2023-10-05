package fr.m2i.globogymsystemspring.service;

import fr.m2i.globogymsystemspring.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(long id);
    void deleteClientById(long id);
}
