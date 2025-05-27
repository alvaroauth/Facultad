
package Practica_4;

public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad; 
    
    public Empleado(String n, double s, int a){
        this.setNombre(n);
        this.setSueldo(s);
        this.setAntiguedad(a);
    }
@Override 
    public String toString(){
        String aux="Nombre: "+this.getNombre()+"\n"+"Sueldo: "+this.getSueldo()+"\n"+"Antiguedad: "+this.getAntiguedad();
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public double calcularSueldoBase(){
        return (this.getSueldo()+(this.getSueldo()*0.10)*this.getAntiguedad());
    }
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    
    
    
    
    
}
