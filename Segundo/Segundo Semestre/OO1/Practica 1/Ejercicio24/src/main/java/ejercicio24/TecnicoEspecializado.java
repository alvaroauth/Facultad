package ejercicio24;

public class TecnicoEspecializado {
    private String nombreCompleto;
    private String especialidad;
    private double valorHora;

    public TecnicoEspecializado(String nom, String esp, double val){
        this.nombreCompleto = nom;
        this.especialidad = esp;
        this.valorHora = val;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getValorHora() {
        return valorHora;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
