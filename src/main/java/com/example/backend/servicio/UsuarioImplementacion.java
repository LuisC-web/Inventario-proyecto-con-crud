package com.example.backend.servicio;

import com.example.backend.dto.UsuarioRegistroDTO;
import com.example.backend.entidades.Rol;
import com.example.backend.entidades.Usuario;

import com.example.backend.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioImplementacion implements UsuarioServicio{
    @Autowired
    private UsuarioRepositorio repositorioUsuario;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
    public UsuarioImplementacion(UsuarioRepositorio repositorioUsuario) {
        super();
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario registrarUsuario(UsuarioRegistroDTO registroDTO) {
        Usuario usuario=new Usuario(registroDTO.getNombre(),registroDTO.getApellido(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROL_USER")));
        return  repositorioUsuario.save(usuario);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= repositorioUsuario.findByEmail(username);
        System.out.println(usuario);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuario o password invalido");

        }
        return new User(usuario.getEmail(),usuario.getPassword(),mapearAutoridadesRoles(usuario.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());

    }
}
