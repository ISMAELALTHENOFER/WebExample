package com.gestion_clientes.controller;

import com.gestion_clientes.dto.ClientRequest;
import com.gestion_clientes.dto.ClientResponse;
import com.gestion_clientes.service.impl.ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
