package co.edu.uniquindio.poo.trabajojavafx.model;

import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private Collection<Libro> listaLibros;
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listaLibros = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(Collection<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
}
