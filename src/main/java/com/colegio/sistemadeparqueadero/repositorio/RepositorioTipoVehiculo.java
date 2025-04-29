package com.colegio.sistemadeparqueadero.repositorio;

import com.colegio.sistemadeparqueadero.entidad.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioTipoVehiculo extends JpaRepository<TipoVehiculo, Integer> {
    Optional<TipoVehiculo> findByNombre(String nombre);
}