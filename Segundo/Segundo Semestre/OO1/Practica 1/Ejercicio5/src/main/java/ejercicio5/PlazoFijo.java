package ejercicio5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
    private LocalDate fecha;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    public PlazoFijo() {}
    public PlazoFijo (LocalDate fecha, double montoDepositado, double porcentajeDeInteresDiario) {
        this.fecha = fecha;
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    @Override
    public double valorActual() {
        long dias = ChronoUnit.DAYS.between(fecha, LocalDate.now());
        return montoDepositado + (dias * (porcentajeDeInteresDiario / 100) * montoDepositado);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMontoDepositado() {
        return montoDepositado;
    }

    public void setMontoDepositado(double montoDepositado) {
        this.montoDepositado = montoDepositado;
    }

    public double getPorcentajeDeInteresDiario() {
        return porcentajeDeInteresDiario;
    }

    public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    @Override
    public String toString() {
        return this.getFecha().toString()+"   "+this.getPorcentajeDeInteresDiario()+"    "+this.getMontoDepositado()+"\n";
    }
}
