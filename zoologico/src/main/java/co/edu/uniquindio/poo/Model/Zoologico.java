package co.edu.uniquindio.poo.Model;

public class Zoologico {
    private final String nombre;
    private final String direccion;

    public Zoologico(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

}
