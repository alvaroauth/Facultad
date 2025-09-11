package ejercicio4;

public class Producto {
    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public Producto(String descripcion, double peso, double precioPorKilo) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
    }

    public Producto(Producto p) {
        this.descripcion = p.getDescripcion();
        this.peso = p.getPeso();
        this.precioPorKilo = p.getPrecioPorKilo();
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
