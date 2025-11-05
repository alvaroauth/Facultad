package ejercicio24;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreCompleto;
    private String domicilio;
    private List<Orden> ordenes;

    public Usuario(String nom, String dom){
        this.nombreCompleto = nom;
        this.domicilio = dom;
        this.ordenes = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void agregarOrden(Orden o){
        this.ordenes.add(o);
    }
}
