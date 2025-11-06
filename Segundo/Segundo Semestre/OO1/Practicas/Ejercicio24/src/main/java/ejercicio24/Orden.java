package ejercicio24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
    private LocalDate fecha;
    private Usuario usuario;
    private String domicilio;
    private List<Producto> productos;

    public Orden(LocalDate f, Usuario u, String dom){
        this.fecha = f;
        this.usuario = u;
        this.domicilio = dom;
        this.productos = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void agregarProducto(Producto p){
        this.productos.add(p);
    }

    public double calcularCosto(){
        return (this.productos.stream().mapToDouble(p -> p.getCosto()).sum() + this.costoAgregado()) * this.descuentoRealizado();
    }

    protected abstract double costoAgregado();

    protected abstract double descuentoRealizado();
}
