package ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private long DNI;
    private List<Propiedad> propiedades;

    public Usuario(String nom, String dir, long dni){
        this.nombre = nom;
        this.direccion = dir;
        this.DNI = dni;
        this.propiedades = new ArrayList<>();
    }

    public double calcularCosto(){
        return this.propiedades.stream().mapToDouble(p -> p.getIngresos()).sum();
    }

    public void agregarPropiedad(Propiedad p){
        this.propiedades.add(p);
    }
}