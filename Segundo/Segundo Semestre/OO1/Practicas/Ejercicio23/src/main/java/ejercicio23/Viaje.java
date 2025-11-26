package ejercicio23;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private double valorTotal;
    private String origen;
    private String destino;
    private LocalDate fechaSalida;
    private Vehiculo vehiculo;
    private List<Usuario> pasajeros;

    public Viaje(Vehiculo v, LocalDate f, String d, String o, double vt, Chofer c) {
        this.vehiculo = v;
        this.fechaSalida = f;
        this.destino = d;
        this.origen = o;
        this.valorTotal = vt;
        pasajeros = new ArrayList<>();
        pasajeros.add(c);
    }

    public boolean registrarPasajero(Pasajero p){
        if (ChronoUnit.DAYS.between(LocalDate.now(), fechaSalida) < 2 || !p.saldoPositivo() || vehiculo.getCapacidad() == pasajeros.size())
            return false;
        pasajeros.add(p);
        p.agregarViaje(this);
        return true;
    }

    public void cobrarViaje(){
        pasajeros.stream().forEach(u -> u.cobrarViaje(this));
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public int getCantPasajeros(){
        return pasajeros.size();
    }
}
