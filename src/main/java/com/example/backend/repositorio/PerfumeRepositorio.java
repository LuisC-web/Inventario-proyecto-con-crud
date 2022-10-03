package com.example.backend.repositorio;

import com.example.backend.entidades.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepositorio extends JpaRepository<Perfume,Long> {

}
