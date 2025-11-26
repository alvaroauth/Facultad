package ejercicio2;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void ponerEnCero(){
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void agregarProducto(Producto p){
        this.cantidadDeProductos++;
        this.pesoTotal += p.getPeso();
        this.precioTotal += p.getPrecio();
    }

    public Ticket emitirTicket(){
        return new Ticket(this.cantidadDeProductos,this.precioTotal,this.pesoTotal);
    }

    public int getCantidadDeProductos() {
        return this.cantidadDeProductos;
    }

    public double getPesoTotal() {
        return this.pesoTotal;
    }

    public double getPrecioTotal() {
        return this.precioTotal;
    }
}
