package ejercicio16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class testDateLapse {
    private DateLapse rango1;
    private DateLapse rango2;

    @BeforeEach
    void construccion(){
        rango1 = new DateLapse(LocalDate.of(2025,1,1), LocalDate.of(2025,1,10));
        rango2 = new DateLapse(LocalDate.of(2024,1,1), LocalDate.of(2025,1,1));
    }

    @Test
    void testGetFrom(){
        assertEquals(LocalDate.of(2025,1,1), rango1.getFrom());
        assertEquals(LocalDate.of(2024,1,1), rango2.getFrom());
    }

    @Test
    void testGetTo(){
        assertEquals(LocalDate.of(2025,1,10), rango1.getTo());
        assertEquals(LocalDate.of(2025,1,1), rango2.getTo());
    }

    @Test
    void testSizeInDays(){
        assertEquals(9, rango1.sizeInDays());
        assertEquals(366, rango2.sizeInDays()); // El 2024 es año bisisesto xd
    }

    @Test
    void testIncludesDate(){
        assertTrue(rango1.includesDate(LocalDate.of(2025,1,5)));
        assertFalse(rango1.includesDate(LocalDate.of(2025,4,5)));
        assertTrue(rango2.includesDate(LocalDate.of(2024,6,1)));
        assertFalse(rango2.includesDate(LocalDate.of(2025,1,2)));
    }
}
