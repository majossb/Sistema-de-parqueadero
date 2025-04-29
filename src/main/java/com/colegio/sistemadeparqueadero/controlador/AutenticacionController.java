package com.colegio.sistemadeparqueadero.controlador;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class AutenticacionController {

    @Controller
    @RequestMapping("/auth")
    public class AutenticacionController {

        @GetMapping("/login")
        public String mostrarLogin() {
            return "auth/login";
        }

        @GetMapping("/redireccion")
        public String redirigirPorRol(Authentication auth) {
            String rol = auth.getAuthorities().iterator().next().getAuthority();
            switch (rol) {
                case "ADMINISTRADOR": return "redirect:/parqueadero/vista-administrador";
                case "ACOMODADOR": return "redirect:/parqueadero/vista-acomodador";
                case "CLIENTE": return "redirect:/parqueadero/vista-cliente";
                default: return "redirect:/auth/login";
            }
        }
    }
}
