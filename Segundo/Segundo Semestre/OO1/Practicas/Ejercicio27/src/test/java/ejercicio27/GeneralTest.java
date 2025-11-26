package ejercicio27;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralTest {

    private C c;

    @BeforeEach
    public void setUp() {
        c = new C();
    }

    @Test
    void inciso1(){
        assertEquals("C.m1 -> B.m1 -> C.m2", c.m1());
    }

    @Test
    void inciso2(){
        assertEquals("C.m2", c.m2());
    }

    @Test
    void inciso3(){
        assertEquals("B.m3 -> A.m3 -> C.m2 -> C.m2 -> C.m3", c.m3());
    }
}
