package enfrentamiento;

public class Mago implements Rol{

    @Override
    public double valorBase(Personaje per) {
        return ((per.getInteligencia() + per.getNivel()) * 2);
    }

    @Override
    public void incrementarHabilidad(Personaje per) {
        per.aumentarInteligencia(per.getNivel() * 1.5);
    }
}
