package ejercicio9;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    private boolean prendida;
    private List<Farola> vecinas;

    public Farola(){
        this.prendida = false;
        this.vecinas = new ArrayList<>();
    }

    public boolean isOn(){
        return this.prendida;
    }

    public boolean isOff(){
        return !this.prendida;
    }

    public List<Farola> getNeighbors(){
        return this.vecinas;
    }

    public void turnOn(){
        if (!this.prendida){
            this.prendida = true;
            for (Farola f : vecinas)
                f.turnOn();
        }
    }

    public void turnOff(){
        if (this.prendida){
            this.prendida = false;
            for (Farola f : vecinas)
                f.turnOff();
        }
    }

    public void pairWithNeighbor(Farola f){
        if (f != null){
            this.vecinas.add(f);
            f.getNeighbors().add(this);
        }
    }
}
