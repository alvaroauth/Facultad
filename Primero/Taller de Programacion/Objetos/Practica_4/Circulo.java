
package Practica_4;

public class Circulo extends Figura {
    private double radio;
    
    public Circulo(double r, String cr, String cl){
        super(cr,cl);
        setRadio(r);
    }
    public String toString (){
        return "Radio: "+getRadio()+super.toString();
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double calcularPerimetro(){
        return 2*this.radio*Math.PI;
    }
    public double calcularArea(){
        return Math.PI*(this.radio*this.radio);
    }
    
    
}
