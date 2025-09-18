package ejercicio8;

import java.time.LocalDate;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero madre;
    private Mamifero padre;

    public Mamifero(String identificador) {
        this.identificador = identificador;
    }

    public Mamifero() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Mamifero getAbueloMaterno() {
        return (this.madre != null)? this.madre.getPadre() : null;
    }

    public Mamifero getAbuelaMaterna() {
        return (this.madre != null)? this.madre.getMadre() : null;
    }

    public Mamifero getAbueloPaterno() {
        return (this.padre != null)? this.padre.getPadre() : null;
    }

    public Mamifero getAbuelaPaterna() {
        return (this.padre != null)? this.padre.getMadre() : null;
    }

    private boolean _tieneComoAncestroA(Mamifero anc){
        if (this == anc)
            return true;

        boolean ok = false;

        if (this.padre != null)
            ok =  this.padre._tieneComoAncestroA(anc);
        if (!ok && this.madre != null)
            ok =  this.madre._tieneComoAncestroA(anc);

        return ok;
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero){
        if (unMamifero != null && this != unMamifero)
            return _tieneComoAncestroA(unMamifero);
        else
            return false;
    }

}
