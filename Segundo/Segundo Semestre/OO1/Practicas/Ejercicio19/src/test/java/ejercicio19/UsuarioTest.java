package ejercicio19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    private Usuario u1, u2;
    private Propiedad p1;

    @BeforeEach
    void setup() throws Exception{
        u1 = new Usuario("Alvaro","Nueva york y Marsella",46013844);
        u2 = new Usuario("Federico","The ovens", 4747474);
        p1 = new Propiedad("Pistacho 6678", "Chocolate dubai c/ pistacho", 7500.0);
        p1.crearReserva(u2,new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,11)));
        p1.crearReserva(u2,new DateLapse(LocalDate.of(2024,1,1), LocalDate.of(2024,1,11)));
        u1.agregarPropiedad(p1);

    }

    @Test
    void testcalcularCosto(){
        assertEquals(150000, u1.calcularCosto());
        assertEquals(0, u2.calcularCosto());
    }
}
