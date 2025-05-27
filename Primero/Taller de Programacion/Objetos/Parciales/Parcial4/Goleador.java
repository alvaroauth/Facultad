package Parciales.Parcial4;

public class Goleador {
    private String nombre;
    private String equipo;
    private int goles;

    public Goleador(String nombre, String equipo, int goles) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.goles = goles;
    }
    public Goleador(){
        this.nombre = "N/N";
        this.equipo = "N/N";
        this.goles = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    @Override
    public String toString(){
        return "( Goleador: "+this.getNombre()+"   Equipo: "+this.getEquipo()+"   Goles: "+this.getGoles()+" )"+"\n";
    }
    
    
}
