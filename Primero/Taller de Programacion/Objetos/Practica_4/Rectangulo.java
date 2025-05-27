
package Practica_4;


public class Rectangulo extends Figura {
    private double base;
    private double altura;
    
    public Rectangulo(double b,double l,String cr,String cl){
        super(cr, cl);
        setAltura(l);
        setBase(b);
        
    }
    public String toString(){
        return "Base: "+this.getBase()+"  Altura: "+this.getAltura()+super.toString();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double calcularPerimetro(){
        return (this.getAltura()+this.getBase())*2;
    }
    public double calcularArea(){
        return this.getAltura()*this.getBase();
    }
    
    
}
