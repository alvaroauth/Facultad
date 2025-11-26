package ejercicio3;

public class Item {
    private String detalle;
    private int cantidad;
    private double costoUnitario;

    public Item(String detalle,int cantidad, double costoUnitario ) {
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.detalle = detalle;
    }

    public double costo(){
        return this.costoUnitario *  this.cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }
}
