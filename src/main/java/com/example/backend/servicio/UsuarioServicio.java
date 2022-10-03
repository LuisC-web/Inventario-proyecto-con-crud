package com.example.backend.servicio;

import com.example.backend.dto.UsuarioRegistroDTO;
import com.example.backend.entidades.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsuarioServicio extends UserDetailsService {
    public Usuario registrarUsuario(UsuarioRegistroDTO usuario);


}
