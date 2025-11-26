package ejercicio11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {
    private CuentaCorriente cc1;
    private CuentaCorriente cc2;

    @BeforeEach
    void setup(){
        cc1 = new CuentaCorriente();
        cc2 = new CuentaCorriente();

        cc1.setLimiteDescubierto(10);
        cc1.depositar(100);
    }

    @Test
    void testExtraccion(){
        assertTrue(cc1.extraer(110));
        assertFalse(cc2.extraer(1));
        assertEquals(-10, cc1.getSaldo());
        assertEquals(0, cc2.getSaldo());
    }

    @Test
    void testDepositos(){
        assertEquals(0, cc2.getSaldo());
        cc2.depositar(1000);
        assertEquals(1000, cc2.getSaldo());
    }

    @Test
    void testTransferencia(){
        assertFalse(cc2.transferirACuenta(1, cc1));
        assertTrue(cc1.transferirACuenta(110, cc2));
        assertFalse(cc1.transferirACuenta(1, cc2));
    }
}
