package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {

    private CajaDeAhorro ca1;
    private CajaDeAhorro ca2;

    @BeforeEach
    void setup(){
        ca1 = new CajaDeAhorro();
        ca2 = new CajaDeAhorro();

        ca1.depositar(104.082);
    }

    @Test
    void testExtraccion(){
        assertTrue(ca1.extraer(100));
        assertFalse(ca2.extraer(1));
        assertEquals(0, ca1.getSaldo(), 0.01);
        assertEquals(0, ca2.getSaldo());
    }

    @Test
    void testDepositos(){
        assertEquals(0, ca2.getSaldo());
        ca2.depositar(100);
        assertEquals(98, ca2.getSaldo());
    }

    @Test
    void testTransferencia(){
        assertFalse(ca2.transferirACuenta(1, ca1));
        assertTrue(ca1.transferirACuenta(100, ca2));
        assertEquals(0, ca1.getSaldo(), 0.01);
        assertEquals(98.0, ca2.getSaldo(), 0.001);
        assertFalse(ca1.transferirACuenta(1, ca2));
    }

}
