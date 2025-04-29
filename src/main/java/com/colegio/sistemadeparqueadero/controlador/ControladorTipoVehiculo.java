package com.colegio.sistemadeparqueadero.controlador;

import ch.qos.logback.core.model.Model;
import com.colegio.sistemadeparqueadero.entidad.TipoVehiculo;
import com.colegio.sistemadeparqueadero.service.ServicioTipoVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/tipos-vehiculo")
public class ControladorTipoVehiculo {

    @Autowired
    private ServicioTipoVehiculo servicio;

    @GetMapping
    public String listarTipos(Model model) {
        model.addAttribute("tipos", servicio.listarTodos());
        return "admin/tipos-vehiculo";
    }

    @PostMapping
    public String guardarTipo(@RequestParam String nombre) {
        TipoVehiculo tipo = new TipoVehiculo();
        tipo.setNombre(nombre);
        servicio.guardar(tipo);
        return "redirect:/admin/tipos-vehiculo";
    }
}