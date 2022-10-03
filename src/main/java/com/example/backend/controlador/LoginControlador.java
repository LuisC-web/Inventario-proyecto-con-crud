package com.example.backend.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {
    @GetMapping("/login")
    public String iniciarSesion(){
        return "pages/login";
    }
}
