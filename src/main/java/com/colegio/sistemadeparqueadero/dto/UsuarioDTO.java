package com.colegio.sistemadeparqueadero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nombreUsuario;
    private String contrasena;
    private String rol;
}