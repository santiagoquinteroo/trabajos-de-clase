package co.edu.uniquindio.poo.Model;

public class Perro extends Animal{

    private String raza;
    public Perro(String nombre, String codigo, String color, byte edad, String raza){
        super(nombre, codigo, color, edad);
        this.raza = raza;
    }

    @Override
    public void comer() {
        System.out.println("El perro está comiendo");
    }

    @Override
    public void dormir() {
        System.out.println("El perro está durmiendo");

    }

    @Override
    public void hacerSonido() {
        System.out.println("El perro está ladrando");

    }
}
