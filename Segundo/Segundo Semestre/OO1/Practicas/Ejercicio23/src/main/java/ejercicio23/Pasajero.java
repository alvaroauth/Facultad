package ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{

    private List<Viaje> viajes;

    public Pasajero(String n, String d){
        super(n, d);
        viajes = new ArrayList<>();
    }

    @Override
    protected double calcularDescuento(Viaje v) {
        return viajes.isEmpty() ? 5000 : 0;
    }

    public boolean saldoPositivo(){
        return this.getSaldo() >= 0;
    }

    public void agregarViaje(Viaje v){
        viajes.add(v);
    }

    public List<Viaje> listarViajes(){
        return viajes;
    }
}
