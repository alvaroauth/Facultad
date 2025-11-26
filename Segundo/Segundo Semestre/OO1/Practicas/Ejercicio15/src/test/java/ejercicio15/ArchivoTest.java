package ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArchivoTest {

    private Archivo a;

    @BeforeEach
    void setUp(){
        a = new Archivo("0123456789");
    }

    @Test
    void test(){
        assertEquals(10, a.tamanio());
    }
}
