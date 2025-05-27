
package Parciales.Parcial9;

public class Vehiculo {
    private String patente;
    private double horas;
    private String marca;
    private String modelo;

    public Vehiculo(String patente, double horas, String marca, String modelo) {
        this.setPatente(patente);
        this.setHoras(horas);
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public String getPatente() {
        return patente;
    }

    private void setPatente(String patente) {
        this.patente = patente;
    }

    public double getHoras() {
        return horas;
    }

    private void setHoras(double horas) {
        this.horas = horas;
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Override
    public String toString(){
        return "Vehiculo: "+this.getMarca()+"   Modelo: "+this.getModelo()+"   Patente: "+this.getPatente()+"   Horas: "+this.getHoras();
    }
    
}
