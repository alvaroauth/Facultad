package ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmailTest {

    private Email e1;
    private Email e2;

    @BeforeEach
    void setUp(){
        e1 = new Email("Hola", "Hola mundo");
        e2 = new Email("123", "45");
        e1.adjuntarArchivo(new Archivo("1"));
        e1.adjuntarArchivo(new Archivo("2"));
        e1.adjuntarArchivo(new Archivo("3"));
        e1.adjuntarArchivo(new Archivo("4"));
        e1.adjuntarArchivo(new Archivo("5"));
    }

    @Test
    void espacioOcupadoTest(){
        assertEquals(19, e1.calcularTamanio());
        assertEquals(5, e2.calcularTamanio());
    }

    @Test
    void buscarTest(){
        assertEquals(e1, e1.contieneTexto("Hola"));
        assertNull(e2.contieneTexto("Chau"));
    }
}
