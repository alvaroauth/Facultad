package ejercicio6;

import java.util.List;

public class Usuario {
    private String nombre;
    private String domicilio;
    private List<Consumo> consumos;

    public Factura crearFactura() {
        if ((consumos == null) || (consumos.isEmpty())) return null;
        Factura factura = new Factura();
    }
}
