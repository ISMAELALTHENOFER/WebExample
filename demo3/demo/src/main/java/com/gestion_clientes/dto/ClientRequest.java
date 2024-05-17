package com.gestion_clientes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    @JsonIgnore
    private Long id;
    @NotBlank
    @Size(max = 50)
    private String firstName;
    private String lastName;
    @NotBlank
    @NotNull
    @Size(max = 8, min = 8)
    private String dni;
    @Email
    private String email;
}
