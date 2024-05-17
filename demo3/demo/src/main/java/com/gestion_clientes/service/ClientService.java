package com.gestion_clientes.service;

import com.gestion_clientes.dto.ClientRequest;
import com.gestion_clientes.dto.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {
    ClientResponse save(ClientRequest clientRequest);

    ClientResponse findOne(Long id);

    List<ClientResponse> findAll();

    ClientResponse delete(Long id);

    ClientResponse update(Long id, ClientRequest clientRequest);

    List<ClientResponse> finByDni(String dni);

    List<ClientResponse> finByFirstNameAndLastName(String firstName, String lastName);


}
