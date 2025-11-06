package enfrentamiento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Personaje {
    private String nombre;
    private int nivel;
    private double inteligencia;
    private double fuerza;
    private Rol rol;

    public Personaje(String nombre, int nivel, int inteligencia, int fuerza, Rol rol){
        this.nombre = nombre;
        this.nivel = nivel;
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        this.rol = rol;
    }

    public int getNivel() {
        return nivel;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public double getFuerza() {
        return fuerza;
    }

    public double poderDeAtaque(){
        return rol.valorBase(this);
    }

    public void subirNivel(){
        this.nivel++;
        if (incrementaHabilidad(this.nivel))
            rol.incrementarHabilidad(this);
    }

    public void aumentarFuerza(double f){
        this.fuerza += f;
    }

    public void aumentarInteligencia(double i){
        this.inteligencia += i;
    }


    public void enfrentarOponente(Personaje rival){
        if (this.poderDeAtaque() >= rival.poderDeAtaque())
            this.subirNivel();
        if (this.poderDeAtaque() <= rival.poderDeAtaque())
            rival.subirNivel();
    }

    public List<Personaje> buscarNivelSimilar(List<Personaje> personajes){
        if (LocalDateTime.now().getHour() == 12)
            return personajes.stream().filter(p -> Math.abs(p.poderDeAtaque() - this.poderDeAtaque()) <= 5).collect(Collectors.toList());
        return personajes.stream().filter(p -> Math.abs(p.poderDeAtaque() - this.poderDeAtaque()) <= 2).collect(Collectors.toList());
    }

    protected abstract boolean incrementaHabilidad(int nivel);
}
