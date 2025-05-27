
package Parciales.Parcial_Repetido3;

public class Encargado extends Trabajador {
    private int empleados;

    public Encargado(int empleados, String nombre, int dni, int ingreso, double sueldo) {
        super(nombre, dni, ingreso, sueldo);
        this.setEmpleados(empleados);
    }

    public int getEmpleados() {
        return empleados;
    }

    private void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
    @Override
    public double getSueldoFinal(){
        double aux = super.getSueldoFinal();
        aux += (1000*this.getEmpleados());
        return aux;
    }
    @Override
    public String toString(){
        return " Encargado - - -   Empleados a su cargo: "+this.getEmpleados()+super.toString();
    }
    
    
}
