package ejercicio2;
import java.time.LocalDate;

public class Ticket {
    private LocalDate fecha;
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Ticket(int cantidadDeProductos, double precioTotal, double pesoTotal) {
        this.fecha = LocalDate.now();
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
    }

    public double impuesto(){
        return precioTotal * 0.21;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
