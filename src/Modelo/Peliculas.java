
package Modelo;

import java.util.Date;


public class Peliculas {
    private int codigoPelicula;
    private String titulo;
    private String genero;
    private String director;
    private Date fecha;

    public int getCodigoPelicula() {
        return codigoPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCodigoPelicula(int codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
