package ejercicio24;

import java.time.LocalDate;

public class OrdenCompra extends Orden{
    private double precioEnvio;

    public OrdenCompra(LocalDate f, Usuario u, String dom, double pe){
        super(f, u, dom);
        this.precioEnvio = pe;
    }

    protected double costoAgregado(){
        return this.precioEnvio;
    }

    protected double descuentoRealizado(){
        return 1;
    }
}
