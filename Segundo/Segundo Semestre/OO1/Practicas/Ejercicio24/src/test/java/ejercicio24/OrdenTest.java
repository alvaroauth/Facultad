package ejercicio24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenTest {

    private OrdenServicio os1;
    private OrdenServicio os2;
    private OrdenCompra oc1;
    private OrdenCompra oc2;

    @BeforeEach
    void setup() throws Exception{
        Producto p1 = new Producto("sanguche","jyq",4500, true);
        Producto p2 = new Producto("menu del dia","sorrentinos",5000, false);
        Producto p3 = new Producto("pala","???",15000, false);
        TecnicoEspecializado t1 = new TecnicoEspecializado("Marcelo Gallardo","No sabe hacer cambios",2);
        TecnicoEspecializado t2 = new TecnicoEspecializado("El diego", "a jugar", 10);

        Usuario u1 = new Usuario("Juan Martinez", "Pompeya 1234");
        Usuario u2 = new Usuario("alvaro845", "Moron 166");

        os1 = new OrdenServicio(LocalDate.now(),u1, "Berisso 1923", "curtir el mambo piola tranqui sin berre",3);
        os2 = new OrdenServicio(LocalDate.now(),u2, "Ensenada 111", "Talar el ceibal :(",11);
        oc1 = new OrdenCompra(LocalDate.now(),u1, "Montevideo 1923", 2500);
        oc2 = new OrdenCompra(LocalDate.now(),u2, "Genova 4595", 100);

        os1.agregarProducto(p1);
        os1.agregarProducto(p2);
        os1.agregarProducto(p3);
        os2.agregarProducto(p2);
        oc1.agregarProducto(p1);
        oc1.agregarProducto(p3);
        os1.agregarTecnicoc(t1);
        os1.agregarTecnicoc(t2);
        u1.agregarOrden(os1);
        u1.agregarOrden(oc1);
        u2.agregarOrden(os2);
        u2.agregarOrden(oc2);
    }

    @Test
    void testCalcularCosto(){
        assertEquals(24536, os1.calcularCosto()); //se la re complicaba no
        assertEquals(4500, os2.calcularCosto()); //descuento
        assertEquals(22000, oc1.calcularCosto());
        assertEquals(100, oc2.calcularCosto()); //envio
    }
}
