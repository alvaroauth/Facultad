package ejercicio24;

public class Producto {
    private String nombre;
    private String tipoMaterial;
    private double costo;
    private boolean esBiodegrdable;

    public Producto(String nom, String tipo, double cos, boolean bio){
        this.nombre = nom;
        this.tipoMaterial = tipo;
        this.costo = cos;
        this.esBiodegrdable = bio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isEsBiodegrdable() {
        return esBiodegrdable;
    }
}
