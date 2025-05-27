
package Practica_4;


public class Entrenador extends Empleado{
    private double campeonatos;
    
    public Entrenador(String n, double s, int a, int c){
        super(n, s, a);
        this.setCampeonatos(c);
    }
    @Override
    public String toString(){
        return super.toString()+"\n"+"Campeonatos: "+this.getCampeonatos();
    }

    public double getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(double campeonatos) {
        this.campeonatos = campeonatos;
    }
    @Override
    public double calcularEfectividad(){
        return (double) this.getCampeonatos()/this.getAntiguedad();
    }
    @Override
    public double calcularSueldoACobrar(){
        double aux = calcularSueldoBase();
        if (this.getCampeonatos()==0)
            return aux;
        if ((this.getCampeonatos()>=1)&&(this.getCampeonatos()<=4))
            return aux+5000;
        if ((this.getCampeonatos()>=5)&&(this.getCampeonatos()<=10))
            return aux+30000;
        else
            return aux+50000;
    }
}
