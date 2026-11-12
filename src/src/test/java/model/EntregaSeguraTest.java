package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaSeguraTest {

    EntregaSegura empresa = new EntregaSegura();

    @Test
    void verificarAceptacion() {
        assertEquals(EstadoServicio.APROBADO, empresa.verificarAceptacion(10));
        assertEquals(EstadoServicio.RECHAZADO, empresa.verificarAceptacion(25));
    }

    @Test
    void calcularCostoDomicilio() {
        assertEquals(20000, empresa.calcularCostoDomicilio(10), 0.01);   // 7000 + 10000 + 3000
        assertEquals(0, empresa.calcularCostoDomicilio(25), 0.01);       // rechazado
    }
}