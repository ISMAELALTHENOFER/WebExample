package com.gestion_clientes.service.impl;

import com.gestion_clientes.dto.ClientRequest;
import com.gestion_clientes.dto.ClientResponse;
import com.gestion_clientes.exception.EntityNotFoundException;
import com.gestion_clientes.model.Client;
import com.gestion_clientes.repository.ClientRepository;
import com.gestion_clientes.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.gestion_clientes.constant.Constant.*;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    protected  static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);


    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ClientResponse save(ClientRequest clientRequest){
        logger.info(INFO_CREATE_MESSAGE+" {}",clientRequest);
        ClientResponse clientResponse;
        try {
            clientResponse = toDto(repository.save(toEntity(clientRequest)));
            logger.info(INFO_CREATE_SUCCESSFUL_MESSAGE+" {}",clientRequest);
            return clientResponse;
        }catch (Exception exception){
            logger.error(exception.getMessage(),clientRequest);
        }
        return null;
    }

    @Override
    @Transactional
    public ClientResponse findOne(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> {
            String message = ENTITY_ERROR_MESSAGE+ id;
            return new EntityNotFoundException(message);
        });

        return toDto(client);
    }

    @Override
    @Transactional
    public List<ClientResponse> findAll() {
        List<Client> clients = repository.findAll();
        return clients
                .stream()
                .map(this::toDto)
                .toList();

    }

    @Override
    @Transactional
    public ClientResponse delete(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> {
            String message = ENTITY_ERROR_MESSAGE+ id;
            return new EntityNotFoundException(message);
        });
        ClientResponse clientResponse = toDto(client);
        repository.delete(client);
        return clientResponse;
    }

    @Override
    @Transactional
    public ClientResponse update(Long id, ClientRequest clientRequest) {
        logger.info(INFO_UPDATE_MESSAGE+" {}",clientRequest);
        Client clientUpdate;
        Optional<Client> clientOptional = repository.findById(id);
        Client client = clientOptional.orElseThrow(() -> {
            String message = ENTITY_ERROR_MESSAGE+ id;
            return new EntityNotFoundException(message);
        });

        clientUpdate = toEntity(clientRequest);
        clientUpdate.setId(client.getId());

       repository.save(clientUpdate);
        return toDto(clientUpdate);
    }

    private ClientResponse toDto(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(client.getId());
        clientResponse.setFirstName(client.getFirstName());
        clientResponse.setLastName(client.getLastName());
        clientResponse.setDni(client.getDni());
        return clientResponse;
    }

    private Client toEntity(ClientRequest clientRequest) {
        Client client = new Client();
        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setDni(clientRequest.getDni());
        return client;
    }
}
