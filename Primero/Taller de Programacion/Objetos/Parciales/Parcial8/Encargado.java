
package Parciales.Parcial8;

public class Encargado extends Trabajador {
    private int empleados;
    
    public Encargado (String nombre, int dni,int ingreso , double sueldo, int empleados){
        super(nombre, dni,ingreso, sueldo);
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
        double aux = this.getSueldo();
        if ((2023-this.getIngreso())> 20)
            aux += (aux*0.10);
        aux += (this.getEmpleados()*1000);
        return aux;
    }
    @Override
    public String toString(){
        return super.toString()+"   Empleados a su cargo: "+this.getEmpleados()+"\n";
    }
    
}
