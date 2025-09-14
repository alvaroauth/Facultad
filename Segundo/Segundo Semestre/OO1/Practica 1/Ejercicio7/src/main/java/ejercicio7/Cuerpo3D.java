package ejercicio7;

public class Cuerpo3D {
    private Figura caraBasal;
    private double altura;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCaraBasal(Figura caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getVolumen(){
        return altura* caraBasal.getArea();
    }

    public double getSuperficieExterior(){
         return 2*caraBasal.getArea() + caraBasal.getPerimetro()*altura;
    }
}
