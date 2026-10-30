package co.edu.uniquindio.poo.trabajojavafx.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

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

    public String agregarLibro(Libro libro) {
        Optional<Libro> encontrado = buscarLibro(libro.getIsbn());
        if (encontrado.isPresent()) {
            return "El libro ya existe";
        }else {
            this.listaLibros.add(libro);
            return "Libro agregado con éxito";
        }
    }

    public String eliminarLibro(Libro libro) {
        Optional<Libro> encontrado = buscarLibro(libro.getIsbn());
        if (encontrado.isPresent()) {
            this.listaLibros.remove(libro);
            return "Libro eliminado con éxito";
        }else return "Libro no existe";

    }

    public Optional<Libro> buscarLibro(String isbn) {
        return listaLibros.stream().filter(l -> l.getIsbn().equals(isbn)).findFirst();
    }

    public boolean actualizarLibro(String isbn, Libro actualizado) {
        Optional<Libro> existente = buscarLibro(isbn);
        if (existente.isEmpty() || actualizado == null) {
            return false;
        }
        Libro existenteLibro = existente.get();
        boolean cambiaIsbn = !isbn.equals(actualizado.getIsbn());
        if (cambiaIsbn&& verificarLibro(actualizado.getIsbn())) {
            return false;
        }
        existenteLibro.setTitulo(actualizado.getTitulo());
        existenteLibro.setIsbn(actualizado.getIsbn());
        existenteLibro.setAutor(actualizado.getAutor());
        existenteLibro.setAnioPublicacion(actualizado.getAnioPublicacion());
        existenteLibro.setCategoria(actualizado.getCategoria());
        existenteLibro.setDisponible(actualizado.isDisponible());
        return true;
    }

    public boolean verificarLibro(String isbn) {
        return buscarLibro(isbn).isPresent();
    }
}
