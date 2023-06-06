package com.softtek.junit_06062023.servicio;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import com.softtek.junit_06062023.modelo.Pelicula;
import com.softtek.junit_06062023.repositorio.IPeliculaRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class ServicioPelisTest {

    @Mock
    IPeliculaRepo peliculaRepo;

    @InjectMocks
    ServicioPelis servicio;

    @Test
    @DisplayName(value = "Pruebas de servicio")
    public void contextLoads() {
        Pelicula entrada = new Pelicula("Africa mía", "Lorem ipsum dolor sit amet","Todo publico","pelicula.jpg");
        Pelicula salida = new Pelicula(1,"Africa mía", "Lorem ipsum dolor sit amet","Todo publico","pelicula.jpg");
        Mockito.when(peliculaRepo.save(entrada)).thenReturn(salida);
        Pelicula resultado = servicio.crear(entrada);
        assertEquals(salida, resultado);
        Mockito.verify(peliculaRepo).save(entrada);
    }

    @Test
    public void probarConsultarUnoConDato(){
        Pelicula salida = new Pelicula(1,"Africa mía", "Lorem ipsum dolor sit amet","Todo publico","pelicula.jpg");
        Mockito.when(peliculaRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(salida));
        Pelicula resultado = servicio.mostrarUno(1);
        assertEquals(salida, resultado);
    }

    @Test
    public void probarConsultarUnoSinDato(){
        Pelicula salida = new Pelicula();
        Mockito.when(peliculaRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Pelicula resultado = servicio.mostrarUno(100);
        assertEquals(salida,resultado);
    }

}