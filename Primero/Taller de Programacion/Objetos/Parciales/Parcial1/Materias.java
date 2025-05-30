
package Parciales.Parcial1;

public class Materias {
    private String nombre;
    private double nota;
    private int fecha;
    
    public Materias(String nom, double nota, int fec){
        this.nombre = nom;
        this.fecha = fec;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public int getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return this.nombre + ": " + Math.round(this.nota) + " " + this.fecha + " | " + "\n";
    }
    
}  

