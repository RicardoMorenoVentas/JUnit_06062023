package com.softtek.junit_06062023.controlador;

import com.softtek.junit_06062023.modelo.Pelicula;
import com.softtek.junit_06062023.servicio.ServicioPelis;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class APIControllerTest {

    @InjectMocks
    APIController controlador;

    @Mock
    ServicioPelis servicio;

    @Test
    public void listarTest() throws Exception {
        Pelicula sim = new Pelicula();
        sim.setIdPelicula(1);
        sim.setTitulo("Africa");
        sim.setSinopsis("xxx");
        sim.setUrlImagen("imagen.jpg");

        List<Pelicula> simulacion = new ArrayList<>();
        simulacion.add(sim);

        Mockito.when(servicio.mostrarTodos()).thenReturn(simulacion);

        final ResponseEntity<List<Pelicula>> respuesta = controlador.consultarTodos();
        Object cuerpo = respuesta.getBody();
        Assertions.assertThat(cuerpo).isInstanceOf(List.class);

        List<Pelicula> lista_peliculas = (List<Pelicula>) cuerpo;
        Assertions.assertThat(lista_peliculas.size()).isEqualTo(1);
        Assertions.assertThat(((List<Pelicula>)respuesta.getBody()).size()).isEqualTo(1);
    }

}