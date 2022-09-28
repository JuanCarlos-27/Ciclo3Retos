package com.ciclo3.repository;

import com.ciclo3.model.Client;
import com.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAllClient() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return clientCrudRepository.findById(id);
    }

    public Client saveClient(Client c) {
        return clientCrudRepository.save(c);
    }
    public boolean deleteClient(Integer id){
        clientCrudRepository.deleteById(id);
        return true;
    }
    public Client updateClient (Client c){
        return clientCrudRepository.save(c);
    }
}
