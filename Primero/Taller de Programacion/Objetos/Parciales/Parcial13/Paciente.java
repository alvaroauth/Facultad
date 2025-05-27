
package Parciales.Parcial13;

public class Paciente {
    private String nombre;
    private boolean obraSocial;
    private double costo;

    public Paciente(String nombre, boolean obraSocial, double costo) {
        this.setNombre(nombre);
        this.setObraSocial(obraSocial);
        this.setCosto(costo);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isObraSocial() {
        return obraSocial;
    }

    private void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public double getCosto() {
        return costo;
    }

    private void setCosto(double costo) {
        this.costo = costo;
    }
    @Override
    public String toString(){
        return " Paciente: "+this.getNombre()+"   Costo por la sesion: "+this.getCosto()+"   ¿Posee obra social?: "+this.isObraSocial();
    }
}
