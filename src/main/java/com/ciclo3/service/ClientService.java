package com.ciclo3.service;

import com.ciclo3.model.Client;
import com.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.getAllClient();
    }
    public Optional<Client> getClientById(Integer id) {
        return clientRepository.getClientById(id);
    }

    public Client saveClient(Client c) {
        return clientRepository.saveClient(c);
    }
    public boolean deleteClient(Integer id){
        return clientRepository.deleteClient(id);
    }
    public Client updateClient (Client c){
        return clientRepository.saveClient(c);
    }
}
