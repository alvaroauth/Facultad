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

    public void setEnergiaActiva(double energiaActiva) {
        this.energiaActiva = energiaActiva;
    }

    public double getEnergiaReactiva() {
        return energiaReactiva;
    }

    public void setEnergiaReactiva(double energiaReactiva) {
        this.energiaReactiva = energiaReactiva;
    }

    public boolean beneficio(){
        return (0.8 >= this.energiaActiva / (Math.sqrt(Math.pow(energiaActiva, 2) + Math.pow(energiaReactiva, 2))));
    }

}
