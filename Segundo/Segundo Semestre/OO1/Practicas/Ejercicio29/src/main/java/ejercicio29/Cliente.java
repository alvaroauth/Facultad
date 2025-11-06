package ejercicio29;

import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private LocalDate fechaInicio;
    private Plan plan;

    public Cliente (String nom, Plan p){
        this.nombre = nom;
        this.fechaInicio = LocalDate.now();
        this.plan = p;
    }

    public double getMontoTotal(LocalDate inicio, LocalDate fin){
        double aux = plan.getCostoTotal() + plan.getMontoActividades(inicio, fin) + plan.getMontoPenalizacion();
        return aux;
    }
}
