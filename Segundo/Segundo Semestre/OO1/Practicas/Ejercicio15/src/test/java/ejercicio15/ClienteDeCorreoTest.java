package ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo cc;
    private Email e;
    private Email e2;

    @BeforeEach
    void setup(){
        Email e1 = new Email("Hola", "Hola mundo");
        e2 = new Email("123", "45");
        e1.adjuntarArchivo(new Archivo("1"));
        e1.adjuntarArchivo(new Archivo("2"));
        e1.adjuntarArchivo(new Archivo("3"));
        e1.adjuntarArchivo(new Archivo("4"));
        e1.adjuntarArchivo(new Archivo("5"));
        e = new Email("weon", "me encontraste");
        Carpeta c1 = new Carpeta("unooo");
        Carpeta c2 = new Carpeta("dosss");
        c1.agregarEmail(e1);
        c2.agregarEmail(e2);
        cc = new ClienteDeCorreo();
        cc.agregarCarpeta(c1);
        cc.agregarCarpeta(c2);
    }

    @Test
    void recibirTest(){
        Email ej = new Email("Ejemplo", "Example");
        cc.recibir(ej);
        assertEquals(ej, cc.buscar("Ejemplo"));
    }

    @Test
    void buscarTest(){
        cc.recibir(e);
        assertEquals(e, cc.buscar("weon"));
        assertEquals(e2, cc.buscar("45"));
        assertNull(cc.buscar("Gallarado mercenario andate"));
    }
}
