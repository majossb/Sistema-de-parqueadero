package com.colegio.sistemadeparqueadero.repositorio;


import com.colegio.sistemadeparqueadero.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}