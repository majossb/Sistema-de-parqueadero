package com.colegio.sistemadeparqueadero.service;

import com.colegio.sistemadeparqueadero.entidad.Usuario;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UsuarioDetailsService {

    @Service
    public class UsuarioDetailsService implements UserDetailsService {

        @Autowired
        private RepositorioUsuario repositorioUsuario;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Usuario usuario = repositorioUsuario.findByUsername(username);
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }

            return User.builder()
                    .username(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles(usuario.getRol().getNombre())
                    .build();
        }
    }
}
