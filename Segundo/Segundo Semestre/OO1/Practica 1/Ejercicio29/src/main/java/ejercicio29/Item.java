package ejercicio29;

public class Item {
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Item(String nom, int cant, double precio){
        this.nombre = nom;
        this.cantidad = cant;
        this.precioUnitario = precio;
    }

    public double getPrecioFinal(){
        return this.cantidad * this.precioUnitario;
    }
}
