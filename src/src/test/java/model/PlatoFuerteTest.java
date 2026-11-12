package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatoFuerteTest {

    PlatoFuerte plato = new PlatoFuerte(101, "Bandeja", "Tradicional", 25000, "20 min", 500,
            TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO);

    @Test
    void calcularPrecioVenta() {
        assertEquals(30000, plato.calcularPrecioVenta(), 0.01);   // +20%
    }

    @Test
    void verificarCalidad() {
        assertTrue(plato.verificarCalidad());       // 500 g y cocción aprobada

        plato.setPesoGramos(100);
        assertFalse(plato.verificarCalidad());      // 100 g es muy poco
    }
}