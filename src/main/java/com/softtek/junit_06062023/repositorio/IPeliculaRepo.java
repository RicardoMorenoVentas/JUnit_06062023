package com.softtek.junit_06062023.repositorio;

import com.softtek.junit_06062023.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepo extends JpaRepository<Pelicula,Integer> {
}
