package com.example.backend.entidades;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "nombre",nullable = false,length = 255,unique = true)
    private String nombre;


    @Column(name = "apellido",nullable = false,length = 255)
    private String apellido;


    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @Column(name = "password",nullable = false,length = 255)
    private String password;
    @Column(name = "roles",nullable = false)
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "id"

            )
            ,
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")

    )
    private Collection<Rol> roles;



    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, String email, String password,Collection<Rol> roles) {
       super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles=roles;
    }

    public Usuario(String nombre, String apellido, String email, String password,Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles=roles;
    }

    public Usuario(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}
