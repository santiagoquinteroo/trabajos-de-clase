package co.edu.uniquindio.poo.Model;

public class Gato extends   Animal {

    private boolean vacunado;

    public Gato(String nombre, String codigo, String color, byte edad, boolean vacunado){
        super(nombre,codigo,color,edad);
        this.vacunado = vacunado;

    }

    @Override
    public void comer() {
        System.out.println("El gato toma leche");
    }

    @Override
    public void dormir() {
        System.out.println("El gato está durmiendo");
    }

    @Override
    public void hacerSonido() {
        System.out.println("El gato está maullando");
    }
}
