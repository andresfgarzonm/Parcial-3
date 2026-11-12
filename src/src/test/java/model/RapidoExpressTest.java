package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RapidoExpressTest {

    RapidoExpress empresa = new RapidoExpress();

    @Test
    void verificarAceptacion() {
        assertEquals(EstadoServicio.APROBADO, empresa.verificarAceptacion(10));
        assertEquals(EstadoServicio.RECHAZADO, empresa.verificarAceptacion(15));
    }

    @Test
    void calcularCostoDomicilio() {
        assertEquals(20000, empresa.calcularCostoDomicilio(10), 0.01);   // 5000 + 15000
        assertEquals(0, empresa.calcularCostoDomicilio(15), 0.01);       // rechazado
    }
}