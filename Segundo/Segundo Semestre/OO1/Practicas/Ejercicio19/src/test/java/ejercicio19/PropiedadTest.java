package ejercicio19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PropiedadTest {
    private Usuario u1, u2;
    private Propiedad p1, p2;
    private Reserva r1, r2;

    @BeforeEach
    void setup() throws Exception{
        u1 = new Usuario("Alvaro","Nueva york y Marsella",46013844);
        u2 = new Usuario("Federico","The ovens", 4747474);
        p1 = new Propiedad("Pistacho 6678", "Chocolate dubai c/ pistacho", 7500.0);
        p2 = new Propiedad("Berisso la chispa 1234", "ranchito con onda", 100.0);
        r1 = p1.crearReserva(u2,new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,11)));
        r2 = p1.crearReserva(u2,new DateLapse(LocalDate.of(2025,11,2), LocalDate.now()));
        u1.agregarPropiedad(p1);
        u1.agregarPropiedad(p2);
    }

    @Test
    void testCrearReserva(){
        assertNotNull(p2.crearReserva(u2,new DateLapse(LocalDate.of(2024,1,1), LocalDate.of(2024,1,11))));
        assertNull(p2.crearReserva(u2,new DateLapse(LocalDate.of(2024,1,1), LocalDate.of(2024,1,5))));
        assertNull(p2.crearReserva(u2,new DateLapse(LocalDate.of(2024,1,1), LocalDate.of(2024,11,15))));
    }

    @Test
    void testCancelarReserva(){
        assertTrue(p1.cancelarReserva(r1));
        assertFalse(p1.cancelarReserva(r2));
    }

    @Test
    void testEstaOcupado(){
        assertFalse(p1.estaDisponible(LocalDate.of(2025,1,1), LocalDate.of(2025,1,7)));
        assertTrue(p1.estaDisponible(LocalDate.of(2020,1,1), LocalDate.of(2021,1,1)));
    }

}
