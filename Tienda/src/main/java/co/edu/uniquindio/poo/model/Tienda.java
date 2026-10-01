package co.edu.uniquindio.poo.model;

import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente>listaClientes = new ArrayList<>();
    private final List<Factura>listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();




    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }


    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String registrarCliente(Cliente cliente){

        Cliente encontrado= buscarCliente(cliente.getDocumento());
        if (encontrado==null){
            listaClientes.add(cliente);
            return "El cliente fue registrado existosamente";
        }else return "Ya existe un cliente con esa información";



    }
   public Cliente buscarCliente(String documento){
       for (Cliente aux : listaClientes){
           if (aux.getDocumento().equalsIgnoreCase(documento)){
            return aux;
           }
       }
       return null;

   }

}
