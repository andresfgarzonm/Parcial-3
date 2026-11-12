package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    Bebida bebida = new Bebida(1, "Limonada", "Natural", 10000, "5 min", 500, "5C",
            EstadoBebida.FRIA, PreparacionEspecial.NO);

    @Test
    void calcularPrecioVenta() {
        assertEquals(11000, bebida.calcularPrecioVenta(), 0.01);   // +10%

        bebida.setPreparacionEspecial(PreparacionEspecial.SI);
        assertEquals(14000, bebida.calcularPrecioVenta(), 0.01);   // +10% + 3000
    }

    @Test
    void verificarCalidad() {
        assertTrue(bebida.verificarCalidad());      // 500 ml está entre 150 y 1500

        bebida.setVolumenMillilitros(100);
        assertFalse(bebida.verificarCalidad());     // 100 ml es muy poco
    }
}