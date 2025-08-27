package ParcialGrafos.Simulacro2024;

public class Ciudad {
    private String ciudad;
    private int dias;

    public Ciudad(String ciudad, int dias) {
        this.ciudad = ciudad;
        this.dias = dias;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}