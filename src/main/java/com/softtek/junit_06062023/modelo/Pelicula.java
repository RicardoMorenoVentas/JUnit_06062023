package com.softtek.junit_06062023.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;
    private String titulo;
    private String sinopsis;
    private String clasificacion;
    private String urlImagen;

    public Pelicula(String titulo, String sinopsis, String clasificacion, String urlImagen) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.urlImagen = urlImagen;
    }
}
