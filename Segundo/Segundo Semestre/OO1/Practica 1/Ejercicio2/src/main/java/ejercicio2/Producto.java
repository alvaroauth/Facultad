package ejercicio2;

public class Producto {
    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public Producto(String descripcion, double peso, double precioPorKilo) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
    }

    public double getPrecio(){
        return precioPorKilo * peso;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
