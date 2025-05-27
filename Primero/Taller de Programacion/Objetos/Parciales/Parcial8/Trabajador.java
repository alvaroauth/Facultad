
package Parciales.Parcial8;

public abstract class Trabajador {
    private String nombre;
    private int dni;
    private double sueldo;
    public int ingreso;
    private double sueldofinal;

    public Trabajador(String nombre, int dni,int ingreso, double sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.sueldofinal = this.getSueldoFinal();
        this.setIngreso(ingreso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public double getSueldofinal() {
        return sueldofinal;
    }

    public void setSueldofinal(double sueldofinal) {
        this.sueldofinal = sueldofinal;
    }
    
    @Override
    public String toString(){
        return "   ---> Nombre: "+this.getNombre()+"   DNI: "+this.getDni()+"   Sueldo base: "+this.getSueldo()+"   Sueldo final: "+this.getSueldoFinal();
    }
    public abstract double getSueldoFinal();
    
    
    
    
}
