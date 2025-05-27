
package Practica_4;


public  class Triangulo extends Figura{
    private double lado1;
    private double lado2;
    private double lado3;
    public Triangulo(double l1, double l2, double l3, String cr, String cl){
        super(cr,cl);
        setLado1(l1);
        setLado2(l2);
        setLado3(l3);
    }
            
    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    public double calcularPerimetro(){
        return this.lado1+this.lado2+this.lado3;
    }
    public double calcularArea(){
        double s = (this.lado1 + this.lado2 +this.lado3)/2.0;
        return Math.sqrt(s*(s-this.lado1)*(s-this.lado2)*(s-this.lado3));
    }
    public String toString() {
        return "L1: "+getLado1()+"  L2: "+getLado2()+"  L3: "+getLado3()+super.toString();
    }
    
    
}
