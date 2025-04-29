package com.colegio.sistemadeparqueadero.controlador;

import ch.qos.logback.core.model.Model;
import com.colegio.sistemadeparqueadero.dto.EntradaParqueaderoDTO;
import com.colegio.sistemadeparqueadero.service.ServicioEntradaParqueadero;
import com.colegio.sistemadeparqueadero.service.ServicioTipoVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class EntradaParquederoController {

    @Controller
    @RequestMapping("/admin/entradas")
    public class EntradaParquederoController {

        @Autowired
        private ServicioEntradaParqueadero servicio;

        @Autowired
        private ServicioTipoVehiculo servicioTipoVehiculo;

        @GetMapping
        public String listarEntradas(Model model) {
            model.addAttribute("entradas", servicio.listarTodas());
            model.addAttribute("tiposVehiculo", servicioTipoVehiculo.listarTodos());
            return "admin/entradas";
        }

        @PostMapping
        public String registrarEntrada(@ModelAttribute EntradaParqueaderoDTO entradaDTO) {
            servicio.registrarEntrada(entradaDTO);
            return "redirect:/admin/entradas";
        }

        @PostMapping("/{id}/salida")
        public String registrarSalida(@PathVariable Long id, @RequestParam Integer horaSalida) {
            servicio.registrarSalida(id, horaSalida);
            return "redirect:/admin/entradas";
        }
    }

    @Controller
    @RequestMapping("/acomodador/entradas")
    public class AcomodadorEntradaController {

        @Autowired
        private ServicioEntradaParqueadero servicio;

        @GetMapping
        public String listarEntradasActivas(Model model) {
            model.addAttribute("entradas", servicio.listarActivas());
            return "acomodador/entradas";
        }

        @PostMapping("/{id}/ubicacion")
        public String actualizarUbicacion(@PathVariable Long id, @RequestParam String ubicacion) {
            servicio.actualizarUbicacion(id, ubicacion);
            return "redirect:/acomodador/entradas";
        }
    }

    @Controller
    @RequestMapping("/cliente/entradas")
    public class ClienteEntradaController {

        @Autowired
        private ServicioEntradaParqueadero servicio;

        @GetMapping
        public String listarEntradas(Model model) {
            model.addAttribute("entradas", servicio.listarTodas());
            return "cliente/entradas";
        }
    }
}
