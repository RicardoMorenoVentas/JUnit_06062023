package com.softtek.junit_06062023.controlador;

import com.softtek.junit_06062023.modelo.Pelicula;
import com.softtek.junit_06062023.servicio.ServicioPelis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    ServicioPelis servicio;

    public ResponseEntity<List<Pelicula>> consultarTodos(){
        List<Pelicula> lPeliculas = servicio.mostrarTodos();
        return new ResponseEntity<>(lPeliculas, HttpStatus.OK);
    }
}
