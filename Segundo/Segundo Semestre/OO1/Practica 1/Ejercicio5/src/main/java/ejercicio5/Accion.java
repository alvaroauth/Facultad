package ejercicio5;

public class Accion implements Inversion {
    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public Accion(String nombre, int cantidad, double valorUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }
    public Accion(){}

    @Override
    public double valorActual() {
        return cantidad * valorUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return this.nombre+"   "+this.cantidad+"   "+this.valorUnitario;
    }
}
