package enfrentamiento;

import java.time.LocalDateTime;

public class Orco extends Personaje{

    public Orco(String nom, Rol rol){
        super(nom, 1, 1, 2, rol);
    }

    @Override
    public double poderDeAtaque() {
        if (LocalDateTime.now().getHour() >= 20 || LocalDateTime.now().getHour() < 8 )
            return super.poderDeAtaque() * 1.6;
        return super.poderDeAtaque();
    }

    protected boolean incrementaHabilidad(int nivel){
        return nivel % 3 == 0;
    }
}
