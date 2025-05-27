
package Parciales.Parcial_Repetido3;

public abstract class Trabajador {
    private String nombre;
    private int dni;
    private int ingreso;
    private double sueldo;

    public Trabajador(String nombre, int dni, int ingreso, double sueldo) {
        this.setNombre(nombre);
        this.setDni(dni);
        this.setIngreso(ingreso);
        this.setSueldo(sueldo);
    }
    
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public int getIngreso() {
        return ingreso;
    }

    private void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    private void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public double getSueldoFinal(){
        double aux = this.getSueldo();
        if (2024-this.getIngreso() > 20)
            aux += (aux*0.10);
        return aux;
    }
    @Override
    public String toString(){
        String aux ="   Nombre: "+this.getNombre()+"   DNI: "+this.getDni()+"   Año de ingreso: "+this.getIngreso()+"   Sueldo Final: "+this.getSueldoFinal();
        return aux;
    }
    
    
}
