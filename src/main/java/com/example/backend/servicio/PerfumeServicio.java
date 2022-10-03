package com.example.backend.servicio;

import com.example.backend.entidades.Perfume;

import java.util.List;

public interface PerfumeServicio {
    public List<Perfume> listarTodosLosPerfumes();
    public Perfume guardarPerfume(Perfume perfume);
    public Perfume obtenerProductoPorId(long id);
    public Perfume actualizarProducto(Perfume perfume);
    public void eliminarProducto(long id);


}
