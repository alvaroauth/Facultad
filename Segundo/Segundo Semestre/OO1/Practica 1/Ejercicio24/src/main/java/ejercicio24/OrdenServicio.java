package ejercicio24;

import java.time.LocalDate;
import java.util.*;

public class OrdenServicio extends Orden{
    private String descripcion;
    private int horas;
    private List<TecnicoEspecializado> tecnicos;

    public OrdenServicio(LocalDate f, Usuario u, String dom, String desc, int h){
        super(f, u, dom);
        this.descripcion = desc;
        this.horas = h;
        this.tecnicos = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarTecnicoc(TecnicoEspecializado t){
        this.tecnicos.add(t);
    }

    protected double costoAgregado(){
        return this.tecnicos.stream().mapToDouble(t -> t.getValorHora() * horas).sum();
    }

    @Override
    protected double descuentoRealizado() {
        return horas >= 10? 0.9 : 1;
    }
}
