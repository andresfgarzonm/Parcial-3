package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostreTest {

    Postre postre = new Postre(1, "Tres leches", "Frío", 10000, "10 min", 200, 4.0,
            RequiereRefrigeracion.NO);

    @Test
    void calcularPrecioVenta() {
        assertEquals(11500, postre.calcularPrecioVenta(), 0.01);   // +15%

        postre.setRequiereRefrigeracion(RequiereRefrigeracion.SI);
        assertEquals(12000, postre.calcularPrecioVenta(), 0.01);   // +20%
    }

    @Test
    void verificarCalidad() {
        assertTrue(postre.verificarCalidad());      // 200 g está entre 80 y 500

        postre.setPesoGramos(50);
        assertFalse(postre.verificarCalidad());     // 50 g es muy poco
    }
}