package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
    private List<Producto> listaProductos;

    public Balanza() {
        this.listaProductos = new ArrayList<>();
    }

    public void ponerEnCero(){
        this.listaProductos.clear();
    }

    public void agregarProducto(Producto p){
        this.listaProductos.add(new Producto(p));
    }

    public Ticket emitirTicket(){
        return new Ticket(this.listaProductos);
    }

    public int getCantidadDeProductos() {
        return this.listaProductos.size();
    }

    public double getPesoTotal() {
        return this.pesoTotal();
    }

    public double getPrecioTotal() {
        return this.precioTotal();
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
