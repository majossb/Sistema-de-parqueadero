package com.colegio.sistemadeparqueadero.dto;


import lombok.Data;

import jakarta.validation.constraints.NotBlank;



@Data
public class LoginDTO {

    @NotBlank
    private String usuario;

    @NotBlank
    private String contraseña;
}