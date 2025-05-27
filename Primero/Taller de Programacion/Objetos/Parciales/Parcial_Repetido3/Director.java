
package Parciales.Parcial_Repetido3;

public class Director extends Trabajador {
    private double viaticos;

    public Director(double viaticos, String nombre, int dni, int ingreso, double sueldo) {
        super(nombre, dni, ingreso, sueldo);
        this.setViaticos(viaticos);
    }

    public double getViaticos() {
        return viaticos;
    }

    private void setViaticos(double viaticos) {
        this.viaticos = viaticos;
    }
    @Override
    public double getSueldoFinal(){
        double aux = super.getSueldoFinal();
        return aux+this.getViaticos();
    }
    @Override
    public String toString(){
        return " Director - - -  Sueldo destinado a viaticos: "+this.getViaticos()+super.toString();
    }
    
    
    
}
