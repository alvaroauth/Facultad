package ejercicio7;

public class Circulo implements Figura {
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public Circulo(){}

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return radio * 2.0;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2.0;
    }

    @Override
    public double getPerimetro() {
        return Math.PI * this.getDiametro();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}
