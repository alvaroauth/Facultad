package ejercicio3;

import java.time.LocalDate;
import java.util.*;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;
    private List<Item> items;

    public Presupuesto(String cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : this.items) {
            total += item.costo();
        }
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }
}
