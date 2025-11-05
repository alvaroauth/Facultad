package ejercicio29;

import java.util.List;

public class SesionDeJuegos {
    public double duracion;
    private List<Item> items;

    public void usarItem(Item i){
        this.items.add(i);
    }

    public double getCosto(){
        if (this.duracion > 360.0)
            return this.items.stream().mapToDouble(i -> i.getPrecioFinal()).sum();
        else
            return 0;
    }
}
