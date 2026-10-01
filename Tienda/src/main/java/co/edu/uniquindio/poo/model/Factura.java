package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate Fecha, double Total, EstadoFactura estado, MetodoPago metodoPago,
                      Cliente cliente, ArrayList<DetalleFactura>listaDetallesFactura, Tienda ownedByTienda) {

    //Los records son clases inmutables osea que los atributos después de asignados no se pueden modificar

}
