package ejercicio19;

import java.time.LocalDate;
import java.util.List;

public class Propiedad {
    private String direccion;
    private String nombreDesc;
    private double precio;
    private List<Reserva> reservas;

    public double getPrecio(){
        return this.precio;
    }

    public double getIngresos(){
        return this.reservas.stream().mapToDouble(r -> r.calcularCosto()).sum();
    }

    private boolean noCoincide(DateLapse per){
        return this.reservas.stream()
                .noneMatch(r -> r.coincidePeriodo(per));
    }

    public Reserva crearReserva(Usuario inq, DateLapse per){
        if (noCoincide(per)){
            Reserva r = new Reserva (inq,this, per);
            this.reservas.add(r);
            return r;
        }
        return null;
    }

    public boolean cancelarReserva(Reserva res){
        if (!res.enCurso() && this.reservas.stream().anyMatch(r -> r.equals(res))){
            this.reservas.remove(res);
            return true;
        }
        return false;
    }

    public boolean estaDisponible(LocalDate desde, LocalDate hasta){
        DateLapse dl = new DateLapse(desde, hasta);
        return this.reservas.stream().anyMatch(r -> r.coincidePeriodo(dl));
    }
}
