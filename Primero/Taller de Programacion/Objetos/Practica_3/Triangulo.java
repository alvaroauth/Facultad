
package Practica_3;

public class Triangulo {
    private double lado1 = 0;
    private double lado2 = 0;
    private double lado3 = 0;
    private String relleno = "";
    private String linea = "";
    
    public Triangulo (double lado1P, double lado2P, double lado3P, String RellenoP, String LineaP){
        lado1 = lado1P;
        lado2 = lado2P;
        lado3 = lado3P;
        relleno = RellenoP;
        linea = LineaP;
    }
    public Triangulo(){
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

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    public double calcularPerimetro(){
        return this.lado1 + this.lado2 +this.lado3;
    }
    public double calcularArea(){
        double s = (this.lado1 + this.lado2 +this.lado3)/2.0;
        return Math.sqrt(s*(s-this.lado1)*(s-this.lado2)*(s-this.lado3));
    }
    public String toString(){
        String aux = ("Lado 1: "+this.getLado1()+"  Lado 2: "+this.getLado2()+"  Lado 3: "+this.getLado3()+"  Color de relleno: "+this.getRelleno()+"  Color de linea: "+this.getLinea()+"  Perimetro: "+this.calcularPerimetro()+"  Area: "+this.calcularArea());
        return aux;
    }
}
