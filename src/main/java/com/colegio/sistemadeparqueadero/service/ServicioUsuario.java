package com.colegio.sistemadeparqueadero.service;

import com.colegio.sistemadeparqueadero.dto.UsuarioDTO;
import com.colegio.sistemadeparqueadero.entidad.Rol;
import com.colegio.sistemadeparqueadero.entidad.Usuario;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioRol;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioRol repositorioRol;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        Rol rol = repositorioRol.findByNombre(usuarioDTO.getRol());
        usuario.setRol(rol);

        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }
}