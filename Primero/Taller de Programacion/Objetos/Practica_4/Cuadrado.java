
package Practica_4;


public class Cuadrado extends Figura{
    private double lado;
    
    public Cuadrado(double l, String cr, String cl){
        super(cr, cl);
        this.setLado(l);
    }
    public String toString(){
        return "Lado: "+this.getLado()+super.toString();
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    public double calcularPerimetro(){
        return 4*this.getLado();
    }
    public double calcularArea(){
        return (this.getLado()*this.getLado());
    }
    
}
