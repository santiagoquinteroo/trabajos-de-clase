package co.edu.uniquindio.poo.Model;

public class Gato extends   Animal {

    public Gato(String nombre, String codigo, String color, byte edad, boolean vacunado){
        super(nombre,codigo,color,edad);


    }

    @Override
    public void comer() {
        System.out.println("El gato toma leche");
    }

    @Override
    public void dormir() {
        super.dormir();
    }

    @Override
    public void hacerSonido() {
        System.out.println("El gato está maullando");
    }
}
