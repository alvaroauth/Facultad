package ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private List<Inversion> inversiones;

    public Inversor() {
        this.inversiones = new ArrayList<Inversion>();
    }

    public void agregarInversion(Inversion inversion) {
        this.inversiones.add(inversion);
    }

    public void borrarInversion(Inversion inversion) {
        this.inversiones.remove(inversion);
    }

    public double valorActual() {
        double valor = 0;
        for (Inversion inversion : this.inversiones) {
            valor += inversion.valorActual();
        }
        return valor;
    }

}
