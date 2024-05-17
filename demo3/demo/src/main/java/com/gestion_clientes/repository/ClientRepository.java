package com.gestion_clientes.repository;

import com.gestion_clientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByDni(String dni);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);
}
