package com.softtek.junit_06062023.servicio;

import com.softtek.junit_06062023.modelo.Pelicula;
import com.softtek.junit_06062023.repositorio.IPeliculaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPelis {
    @Autowired
    IPeliculaRepo peliculaRepo;

    public Pelicula crear(Pelicula peli_e){
        return peliculaRepo.save(peli_e);
    }

    public Pelicula mostrarUno(int id){
        return peliculaRepo.findById(id).orElse(new Pelicula());
    }

    public List<Pelicula> mostrarTodos(){
        return peliculaRepo.findAll();
    }
}
