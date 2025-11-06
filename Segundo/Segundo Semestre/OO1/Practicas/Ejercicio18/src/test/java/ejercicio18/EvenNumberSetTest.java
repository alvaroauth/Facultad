package ejercicio18;

import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EvenNumberSetTest {
    private Set<Integer> conjunto;

    @BeforeEach
    void construccion(){
        conjunto = new EvenNumberSet();
        conjunto.add(2);
    }

    @Test
    void addEvenTest(){
        assertTrue(conjunto.add(4));
        assertTrue(conjunto.contains(4));
    }

    @Test
    void addDuplicateTest(){
        assertFalse(conjunto.add(2));
        assertTrue(conjunto.contains(2));
    }

    @Test
    void addNotEvenTest(){
        assertFalse(conjunto.add(3));
        assertFalse(conjunto.contains(3));
    }

}
