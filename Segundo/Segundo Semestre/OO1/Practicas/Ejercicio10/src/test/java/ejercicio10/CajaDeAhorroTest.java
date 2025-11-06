package ejercicio10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    CajaDeAhorro caja1, caja2;

    @BeforeEach
    void Setup() throws Exception{
        caja1 = new CajaDeAhorro();
        caja2 = new CajaDeAhorro();

        caja1.depositar(10000);
    }

    @Test
    public void TestDepositos(){
        caja2.depositar(100);
        assertEquals(98, caja2.getSaldo());
    }

    @Test
    public void TestTransferencias(){
        assertEquals(0, caja2.getSaldo());
        assertEquals(9800, caja1.getSaldo());
        assertTrue(caja1.transferirAOtraCuenta(9604, caja2));
        assertEquals(0, caja1.getSaldo());
        assertEquals(9604, caja2.getSaldo());
    }

    @Test
    public void TestExtraccion(){
        assertTrue(caja1.extraer(10000));
        assertFalse(caja2.extraer(999999));    }
}
