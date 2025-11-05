package ejercicio29;

import java.util.stream.Collectors;

public class PlanGrupal extends Plan{

    public PlanGrupal(int cant){
        super(cant);
    }

    public double getCostoTotal(){
        return this.getCantMaximaIP() * 800.0;
    }

    public double getMontoPenalizacion(){
            int auxIP = this.getActividades().stream().map(a -> a.getIP()).collect(Collectors.toSet()).size() - getCantMaximaIP();
            if (auxIP > 0)
                return auxIP * 500.0;
        return 0;
    }
}
