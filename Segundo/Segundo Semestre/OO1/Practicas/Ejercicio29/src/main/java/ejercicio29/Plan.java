package ejercicio29;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Plan {
    private int cantMaximaIP;
    private List<Actividad> actividades;

    public Plan(int cant){
        this.cantMaximaIP = cant;
        this.actividades = new ArrayList<>();
    }

    public int getCantMaximaIP(){
        return this.cantMaximaIP;
    }

    public void agregarActividad(Actividad a){
        this.actividades.add(a);
    }

    public double getMontoActividades(LocalDate inicio, LocalDate fin){
        return this.actividades.stream().filter(a ->
                a.getFechaInicio().isAfter(inicio) || a.getFechaInicio().isEqual(inicio) ||
                a.getFechaInicio().isBefore(fin) || a.getFechaInicio().isEqual(fin))
                .mapToDouble(a -> a.getCosto()).sum();
    }

    protected List<Actividad> getActividades(){
        return this.actividades;
    }

    public abstract double getMontoPenalizacion();

    public abstract double getCostoTotal();
}
