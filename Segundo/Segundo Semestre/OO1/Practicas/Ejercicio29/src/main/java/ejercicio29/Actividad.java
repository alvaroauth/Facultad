package ejercicio29;

import java.time.LocalDate;

public abstract class Actividad {
    private String IP;
    private LocalDate fechaInicio;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getIP(){
        return IP;
    }

    public abstract double getCosto();
}
