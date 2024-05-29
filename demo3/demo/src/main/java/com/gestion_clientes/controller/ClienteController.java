package com.gestion_clientes.controller;

import com.gestion_clientes.dto.ClientFirstNameAndLastNameRequest;
import com.gestion_clientes.dto.ClientRequest;
import com.gestion_clientes.dto.ClientResponse;
import com.gestion_clientes.service.impl.ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Slf4j
public class ClienteController {
    private ClientServiceImpl service;
    protected static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    public ClienteController(ClientServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest request) {
        logger.info("Controller save: {}", request);
        ClientResponse response = service.save(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{dni}")
    public ResponseEntity<List<ClientResponse>> findByDni(@PathVariable String dni) {
        logger.info("Controller buscar por Dni: {}", dni);

        List<ClientResponse> response = service.finByDni(dni);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find")
    public ResponseEntity<List<ClientResponse>> findByFirstNameAndLastName(@RequestBody ClientFirstNameAndLastNameRequest request) {
        logger.info("Controller buscar por FirstName: {} and lastName:{}", request.getFirstName(), request.getLastName());

        List<ClientResponse> response = service.finByFirstNameAndLastName(request.getFirstName(), request.getLastName());
        return ResponseEntity.ok(response);
    }
}
