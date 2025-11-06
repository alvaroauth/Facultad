package ejercicio6;

public class Consumo {
    private double energiaActiva;
    private double energiaReactiva;

    public Consumo(double energiaActiva, double energiaReactiva) {
        this.energiaActiva = energiaActiva;
        this.energiaReactiva = energiaReactiva;
    }

    public double getEnergiaActiva() {
        return energiaActiva;
    }

    public double getEnergiaReactiva() {
        return energiaReactiva;
    }

    public double getPrecio(double p){
        return energiaActiva * p;
    }

    public boolean beneficio(){
        return (0.8 >= this.energiaActiva / (Math.sqrt(Math.pow(energiaActiva, 2) + Math.pow(energiaReactiva, 2))));  //no tengo la mas minima idea de por que va asi
    }

}
