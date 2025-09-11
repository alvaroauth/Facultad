package ejercicio4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private LocalDate fecha;
    private List<Producto> listaProductos;

    public Ticket(List<Producto> listaProductos) {
        this.fecha = LocalDate.now();
        this.listaProductos = new ArrayList<>();
        this.listaProductos.addAll(listaProductos);
    }

    public double impuesto(){
        return this.precioTotal() * 0.21;
    }

    public int getCantidadDeProductos() {
        return this.listaProductos.size();
    }

    public double getPrecioTotal() {
        return this.precioTotal();
    }

    public double getPesoTotal() {
        return this.pesoTotal();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    private double precioTotal() {
        double precioTotal = 0;
        for (Producto producto : this.listaProductos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    private double pesoTotal() {
        double pesoTotal = 0;
        for (Producto producto : this.listaProductos) {
            pesoTotal += producto.getPeso();
        }
        return pesoTotal;
    }
}
