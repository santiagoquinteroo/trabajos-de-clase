package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
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

        Optional <Cliente> encontrado= buscarCliente(cliente.getDocumento());
        if (encontrado==null){
            listaClientes.add(cliente);
            return "El cliente fue registrado existosamente";
        }else return "Ya existe un cliente con esa información";



    }

    public String eliminarCliente(Cliente cliente){
        Optional <Cliente> encontrado = buscarCliente(cliente.getDocumento());
        if (encontrado!=null){
            listaClientes.remove(cliente);
            return "Cliente eliminado con exito";
        }else return "El cliente no existe";

    }

   public Optional <Cliente> buscarCliente(String documento){
       for (Cliente aux : listaClientes){
           if (aux.getDocumento().equalsIgnoreCase(documento)){
            return Optional.of(aux);
           }
       }
       return Optional.empty();

   }

   public String registrarProducto(Producto producto){

        Optional <Producto> productoEncontrado = buscarProducto(producto.getCodigo());
        if (productoEncontrado.isEmpty()){

            listaProductos.put(producto.getCodigo(), producto);
            return "Producto registrado existosamente";
        }else return "Ya existe un producto con esos datos";


    }
    public String eliminarProducto(Producto producto){
        Optional <Producto> productoEncontrado = buscarProducto(producto.getCodigo());
        if (productoEncontrado!=null){
            listaProductos.remove(producto.getCodigo(), producto);
            return  "Producto eliminado con exito";
        }else  return "No existe producto con esa información";

    }

    public Optional <Producto> buscarProducto(String codigo){
        if (listaProductos.containsKey(codigo)){
            return Optional.of(listaProductos.get(codigo));
        }
        return Optional.empty();
    }

    public String registrarFactura (Factura factura) {
        Optional<Factura> facturaEncontrada = buscarFactura(factura.codigo());
        if (facturaEncontrada == null) {
            listaFacturas.add(factura);
            return "Factura registrada con exito";
        } else return "Factura ya existente";

    }
    public String eliminarFactura (Factura factura) {
        Optional<Factura> facturaEncontrada = buscarFactura(factura.codigo());
        if (facturaEncontrada != null) {
            listaFacturas.remove(factura);
            return "Factura eliminada con exito";
        } else return "Factura no existente";

    }


    public Optional <Factura> buscarFactura (String codigo){
        for (Factura aux : listaFacturas){
            if (aux.codigo().equalsIgnoreCase(codigo)){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }



}







