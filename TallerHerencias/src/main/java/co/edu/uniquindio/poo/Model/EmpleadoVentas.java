package co.edu.uniquindio.poo.Model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria,
                          float descuentoSalud, float descuentoPension, float porcentajeComision, float totalVentas) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.porcentajeComision = porcentajeComision;
        this.totalVentas = totalVentas;
    }

    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        float salarioBruto = (float) (getSalarioBase() + (getSalarioBase()*calcularBonificacion())+(getSalarioBase()*(porcentajeComision/100)));
        if (salarioBruto>=0){
            return salarioBruto;
        }else return 0;
    }

    @Override
    public double calcularBonificacion() {
        return super.calcularBonificacion();
    }
}
