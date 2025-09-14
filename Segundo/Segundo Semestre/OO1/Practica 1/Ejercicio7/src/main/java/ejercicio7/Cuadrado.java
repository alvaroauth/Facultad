package ejercicio7;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public Cuadrado() {}

    public double getLado(){
        return this.lado;
    }

    public void setLado(double lado){
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return Math.pow(this.lado, 2);
    }

    @Override
    public double getPerimetro() {
        return lado * 4;
    }
}
