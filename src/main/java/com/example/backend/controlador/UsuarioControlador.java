package com.example.backend.controlador;

import com.example.backend.dto.UsuarioRegistroDTO;
import com.example.backend.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class UsuarioControlador {
private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }
@ModelAttribute("usuario")
    public UsuarioRegistroDTO nuevoUsuarioRegistroDTO(){
        return  new UsuarioRegistroDTO();

    }

  @GetMapping
    public String mostrarFormularioRegistro(){

        return "pages/registro";
  }
  @PostMapping
    public String registrarNuevoUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){
usuarioServicio.registrarUsuario(registroDTO);
return "redirect:/registro?exito";
  }
}
