package enfrentamiento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanoTest {
    private Humano h1;
    private Humano h2;

    @BeforeEach
    void setup(){
        Guerrero g = new Guerrero();
        Mago m = new Mago();
        h1 = new Humano("Pato",g);
        h2 = new Humano("Magordito",m);

        h1.subirNivel();
        h1.subirNivel();
        h1.subirNivel();
        h1.subirNivel();
        h1.subirNivel();
    }

    @Test
    void testSubirNivel(){
        assertEquals(1,h2.getNivel());
        assertEquals(6, h1.getNivel());
        if (((LocalDateTime.now().getHour() >= 8) && (LocalDateTime.now().getHour() < 20))){
            assertEquals(12.6, h1.poderDeAtaque());
            assertEquals(8.399999999999999, h2.poderDeAtaque());
        }
        else {
            assertEquals(6, h2.poderDeAtaque());
            assertEquals(10, h1.poderDeAtaque());
        }
    }
}
