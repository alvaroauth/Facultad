package ejercicio29;

public class ReproduccionDeVideo extends Actividad{
    private double duracionTotal;
    private double duracionPublicidad;

    public double getDuracionReal(){
        return this.duracionTotal - this.duracionPublicidad;
    }

    public double getCosto(){
        return this.getDuracionReal() * 10.0;
    }
}
