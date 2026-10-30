package co.edu.uniquindio.poo.empresa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empresa {
    private String nombre;
    private List<Empleado>listaEmpleados= new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String registrarEmpleado(Empleado empleado){
        Optional<Empleado> encontrado = buscarEmpleado(empleado.getUser());
        if (encontrado.isPresent()){
            return "Empleado ya existe";

        }else  {
            listaEmpleados.add(empleado);
            return "Empleado registrado con éxito";
        }

    }

    public Optional<Empleado> buscarEmpleado(String identificacion){
        return listaEmpleados.stream().filter(e -> e.getUser().equals(identificacion)).findFirst();
    }

    public boolean verificarUsuario(Empleado empleado){
        return  listaEmpleados.stream().anyMatch(e -> e.getUser().equals(empleado.getUser()));
    }
}
