package ejercicio29;

import java.util.stream.Collectors;

public class PlanIndividual extends Plan{
    private double minutosContratados;

    public PlanIndividual(){
        super(1);
    }

    public double getCostoTotal(){
        return this.minutosContratados * 20.0;
    }

    public double getMontoPenalizacion() {
        int auxIP = this.getActividades().stream().map(a -> a.getIP()).collect(Collectors.toSet()).size();
        if (auxIP > 1)
            return auxIP * 300.0;
        return 0;
    }
}
