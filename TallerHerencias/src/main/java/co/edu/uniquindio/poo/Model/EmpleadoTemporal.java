package co.edu.uniquindio.poo.Model;

public class EmpleadoTemporal extends Empleado{
    private final int diasTrabajados;
    private final float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria,
                            float descuentoSalud, float descuentoPension, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        float salarioBruto = (float) (getSalarioBase() + (diasTrabajados*valorDia+(getSalarioBase()*calcularBonificacion())));
        if (salarioBruto>=0){
            return salarioBruto;
        }else return 0;
    }

    @Override
    public double calcularBonificacion() {
        return super.calcularBonificacion();
    }
}
