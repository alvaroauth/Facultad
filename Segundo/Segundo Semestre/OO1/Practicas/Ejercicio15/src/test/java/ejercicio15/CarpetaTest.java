package ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarpetaTest {
    private Carpeta c1;
    private Carpeta c2;
    private Email e;

    private Email emailEjemplo1(){
        Email e = new Email("Hola", "Hola mundo");
        e.adjuntarArchivo(new Archivo("1"));
        e.adjuntarArchivo(new Archivo("2"));
        e.adjuntarArchivo(new Archivo("3"));
        e.adjuntarArchivo(new Archivo("4"));
        e.adjuntarArchivo(new Archivo("56"));
        return e;
    }

    private Email emailEjemplo2(){
        return new Email("12345", "67890");
    }

    @BeforeEach
    void setUp(){
        c1 = new Carpeta("Holaa");
        c2 = new Carpeta("qonda");

        c1.agregarEmail(emailEjemplo1());
        c1.agregarEmail(emailEjemplo2());
        c2.agregarEmail(emailEjemplo2());

        e = new Email("weon", "me encontraste");
    }

    @Test
    void calcularEspacioTest(){
        assertEquals(35, c1.calcularTamanio());
        assertEquals(15, c2.calcularTamanio());
    }

    @Test
    void buscarTest(){
        c1.agregarEmail(e);
        assertEquals(e, c1.buscarTexto("me"));
        assertNull(c2.buscarTexto("me"));
    }

    @Test
    void moverTest(){
        c1.agregarEmail(e);
        assertTrue(c1.contieneEmail(e));
        c1.mover(e, c2);
        assertFalse(c1.contieneEmail(e));
        assertTrue(c2.contieneEmail(e));
    }
}
