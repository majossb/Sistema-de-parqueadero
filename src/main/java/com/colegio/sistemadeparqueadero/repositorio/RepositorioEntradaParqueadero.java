package com.colegio.sistemadeparqueadero.repositorio;


import com.colegio.sistemadeparqueadero.entidad.EntradaParqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEntradaParqueadero extends JpaRepository<EntradaParqueadero, Long> {
}