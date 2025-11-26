package ejercicio23;

import java.time.LocalDate;

public class Vehiculo {
    private double valorMercado;
    private int capacidad;
    private LocalDate fechaFabricacion;
    private String descripcion;

    public Vehiculo(double valorMercado, int capacidad, LocalDate fechaFabricacion, String descripcion) {
        this.valorMercado = valorMercado;
        this.capacidad = capacidad;
        this.fechaFabricacion = fechaFabricacion;
        this.descripcion = descripcion;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
