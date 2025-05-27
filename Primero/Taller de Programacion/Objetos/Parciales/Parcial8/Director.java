
package Parciales.Parcial8;

public class Director extends Trabajador{
    private double viaticos;
    
    public Director(String nombre, int dni,int ingreso , double sueldo, double viaticos){
        super(nombre, dni,ingreso, sueldo);
        this.setViaticos(viaticos);
    }

    public double getViaticos() {
        return viaticos;
    }

    private void setViaticos(double viaticos) {
        this.viaticos = viaticos;
    }
    @Override
    public String toString(){
        return super.toString()+"   Monto destinado a viaticos: "+this.getViaticos()+"\n";
    }
    
    @Override
    public double getSueldoFinal(){
        double aux = this.getSueldo();
        if ((2023-this.getIngreso())> 20)
            aux += (aux*0.10);
        aux += this.getViaticos();
        return aux;
    }
}
