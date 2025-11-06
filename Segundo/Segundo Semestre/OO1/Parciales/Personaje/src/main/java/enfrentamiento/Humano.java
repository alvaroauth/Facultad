package enfrentamiento;

import java.time.LocalDateTime;

public class Humano extends Personaje{

    public Humano(String nom, Rol rol){
        super(nom, 1, 2, 1, rol);
    }

    @Override
    public double poderDeAtaque() {
        if ((LocalDateTime.now().getHour() >= 8) && (LocalDateTime.now().getHour() < 20 ))
            return super.poderDeAtaque() * 1.4;
        return super.poderDeAtaque();
    }

    protected boolean incrementaHabilidad(int nivel){
        return nivel >= 7;
    }
}
