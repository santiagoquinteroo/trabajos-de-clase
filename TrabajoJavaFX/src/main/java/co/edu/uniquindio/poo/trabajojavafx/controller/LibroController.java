package co.edu.uniquindio.poo.trabajojavafx.controller;

import co.edu.uniquindio.poo.trabajojavafx.model.Libro;
import co.edu.uniquindio.poo.trabajojavafx.model.Biblioteca;

import java.util.Collection;

public class LibroController {
     private final Biblioteca biblioteca;

     public LibroController(Biblioteca biblioteca) {
         this.biblioteca = biblioteca;
     }

     public String crearLibro(Libro libro) {
         return biblioteca.agregarLibro(libro);
     }

     public Collection<Libro> getListaLibros() {
        return biblioteca.getListaLibros();
     }

     public String eliminarLibro(Libro libro) {
         return biblioteca.eliminarLibro(libro);
     }
     public boolean actualizarLibro(String isbn, Libro libro) {
         return biblioteca.actualizarLibro(isbn, libro);
     }
}
