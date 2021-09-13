package com.kagotsi.katabank.services;

import com.kagotsi.katabank.models.Client;
import com.kagotsi.katabank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public  Client save(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> findById(Long id){
        return  clientRepository.findById(id);
    }
}
