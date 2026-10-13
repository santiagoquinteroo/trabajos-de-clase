package co.edu.uniquindio.poo.Model;

import java.util.Objects;

public abstract class Animal {
    private final String nombre;
    private final String codigo;
    private final String color;
    private byte edad;

    public Animal(String nombre, String codigo, String color, byte edad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.color = color;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getColor() {
        return color;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(codigo, animal.codigo);
    }

    public abstract void comer();

    public void dormir(){
        System.out.println("El animal está durmiendo");
    }
    public abstract void  hacerSonido();



}
