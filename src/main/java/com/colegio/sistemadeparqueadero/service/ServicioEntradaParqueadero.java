package com.colegio.sistemadeparqueadero.service;


import com.colegio.sistemadeparqueadero.dto.EntradaParqueaderoDTO;
import com.colegio.sistemadeparqueadero.entidad.EntradaParqueadero;
import com.colegio.sistemadeparqueadero.entidad.TipoVehiculo;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioEntradaParqueadero;
import com.colegio.sistemadeparqueadero.repositorio.RepositorioTipoVehiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioEntradaParqueadero {

    private final RepositorioEntradaParqueadero repositorioEntradaParqueadero;
    private final RepositorioTipoVehiculo repositorioTipoVehiculo;

    public List<EntradaParqueadero> listar() {
        return repositorioEntradaParqueadero.findAll();
    }

    public EntradaParqueadero guardar(EntradaParqueaderoDTO dto) {
        EntradaParqueadero entrada = new EntradaParqueadero();

        entrada.setPlaca(dto.getPlaca());
        entrada.setHoraEntrada(dto.getHoraEntrada());
        entrada.setHoraSalida(dto.getHoraSalida());
        entrada.setUbicacion(dto.getUbicacion());

        TipoVehiculo tipoVehiculo = repositorioTipoVehiculo.findById(dto.getTipoVehiculoId())
                .orElseThrow(() -> new RuntimeException("Tipo de vehículo no encontrado"));

        entrada.setTipoVehiculo(tipoVehiculo);

        return repositorioEntradaParqueadero.save(entrada);
    }

    public void eliminarPorId(Long id) {
        repositorioEntradaParqueadero.deleteById(id);
    }
}