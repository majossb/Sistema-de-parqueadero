package com.colegio.sistemadeparqueadero.repositorio;

import com.colegio.sistemadeparqueadero.entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioRol extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}