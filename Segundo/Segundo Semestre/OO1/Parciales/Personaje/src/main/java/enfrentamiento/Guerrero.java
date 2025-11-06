package enfrentamiento;

public class Guerrero implements Rol{

    @Override
    public double valorBase(Personaje per) {
        return (per.getFuerza() * 2) + per.getNivel() + per.getFuerza();
    }

    @Override
    public void incrementarHabilidad(Personaje per) {
        per.aumentarFuerza(per.getNivel()/6.0);
    }
}
