package ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class Chofer extends Usuario{

    private List<Vehiculo> vehiculos;

    public Chofer(Vehiculo v, String n, String d){
        super(n, d);
        vehiculos = new ArrayList<>();
        vehiculos.add(v);
    }

    @Override
    protected double calcularDescuento(Viaje v) {
        return v.getVehiculo().getValorMercado() * 0.001;
    }
}
