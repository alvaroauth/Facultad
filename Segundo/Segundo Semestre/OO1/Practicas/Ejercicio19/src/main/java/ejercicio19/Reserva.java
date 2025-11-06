package ejercicio19;

import java.time.LocalDate;

public class Reserva {
    private DateLapse periodo;
    private Usuario inquilino;
    private Propiedad propiedad;

    public Reserva(Usuario inq, Propiedad prop, DateLapse per){
        this.propiedad = prop;
        this.inquilino = inq;
        this.periodo = per;
    }

    public double calcularCosto(){
        return (double)periodo.sizeInDays() * propiedad.getPrecio();
    }

    public boolean enCurso(){
        return this.periodo.includesDate(LocalDate.now());
    }

    public boolean coincidePeriodo(DateLapse per){
        return this.periodo.overlaps(per);
    }
}
