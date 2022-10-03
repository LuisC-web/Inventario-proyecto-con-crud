package com.example.backend.entidades;

import javax.persistence.*;

@Entity
@Table(name = "perfumes")
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "nombre",nullable = false,length = 255,unique = true)
    private String nombre;

    public Perfume(String nombre, String fragancia, String genero, String marca, Integer cantidad) {
        this.nombre = nombre;
        this.fragancia = fragancia;
        this.genero = genero;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    @Column(name = "fragancia",nullable = false,length = 255)
    private String fragancia;

    public Perfume() {
    }

    @Column(name = "genero",nullable = false,length = 50)
    private String genero;
    @Column(name = "marca",nullable = false,length = 255)
    private String marca;
    @Column(name = "cantidad",nullable = false,length = 255)
    private Integer cantidad;

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

    public String getFragancia() {
        return fragancia;
    }

    public void setFragancia(String fragancia) {
        this.fragancia = fragancia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fragancia='" + fragancia + '\'' +
                ", genero='" + genero + '\'' +
                ", marca='" + marca + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
