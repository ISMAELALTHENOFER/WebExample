package com.gestion_clientes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
}
