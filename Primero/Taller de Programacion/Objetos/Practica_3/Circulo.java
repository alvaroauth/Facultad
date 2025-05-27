
package Practica_3;


public class Circulo {
    private double radio;
    private String relleno;
    private String linea;
    
    public Circulo (double r, String rell, String lin){
        radio = r;
        relleno = rell;
        linea = lin;
    }

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
        return 2*this.radio*Math.PI;
    }
    public double calcularArea(){
        return Math.PI*(this.radio*this.radio);
    }
    @Override
    public String toString(){
        return "¡Hola! Soy Ball-entin el ciruclo, mi radio es: "+this.radio+", Mi color de relleno es "+this.relleno+", Mi color de lineas es "+this.linea+", Mi perimetro es "+this.calcularPerimetro()+" y mi area es "+this.calcularArea();

    }
    
}
