package com.example.backend.servicio;

import com.example.backend.entidades.Perfume;
import com.example.backend.repositorio.PerfumeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PerfumeServicioImplementacion implements PerfumeServicio{
    @Autowired
    private PerfumeRepositorio repositorio;
    @Override
    public List<Perfume> listarTodosLosPerfumes() {
        return repositorio.findAll();
    }

    @Override
    public Perfume guardarPerfume(Perfume perfume) {
        return repositorio.save(perfume);
    }

    @Override
    public Perfume obtenerProductoPorId(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Perfume actualizarProducto(Perfume perfume) {
        return repositorio.save(perfume);
    }

    @Override
    public void eliminarProducto(long id) {
         repositorio.deleteById(id);
    }
}
