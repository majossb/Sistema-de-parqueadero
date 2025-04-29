package com.colegio.sistemadeparqueadero.service;


import com.colegio.sistemadeparqueadero.entidad.TipoVehiculo;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioTipoVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTipoVehiculo {

    @Autowired
    private RepositorioTipoVehiculo repositorioTipoVehiculo;

    public List<TipoVehiculo> listarTodos() {
        return repositorioTipoVehiculo.findAll();
    }

    public TipoVehiculo guardar(TipoVehiculo tipoVehiculo) {
        return repositorioTipoVehiculo.save(tipoVehiculo);
    }
}