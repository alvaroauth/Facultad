
package Practica_4;

public class Jugador extends Empleado {
    private int partidos;
    private int goles;
    
    public Jugador(String n, double s, int a, int p, int g){
        super(n, s, a);
        setGoles(g);
        setPartidos(p);
    }
    
    @Override
    public String toString(){
        return super.toString()+"\n"+"Partidos: "+this.getPartidos()+"\n"+"Goles: "+this.getGoles();
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    @Override
    public double calcularEfectividad(){
    double aux = (double) this.getGoles()/this.getPartidos();
        return aux;
    }
    @Override
    public double calcularSueldoACobrar(){
        double aux = this.calcularSueldoBase();
        if (aux>0.5)
            return aux+this.getSueldo();
        else
            return aux;
    }
    
}
