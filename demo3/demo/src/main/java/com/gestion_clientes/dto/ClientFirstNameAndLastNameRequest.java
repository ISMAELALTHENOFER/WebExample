package com.gestion_clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientFirstNameAndLastNameRequest {
    private String firstName;
    private String lastName;
}
