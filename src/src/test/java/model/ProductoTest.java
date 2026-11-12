package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Producto es abstracta, así que se prueba usando una Bebida como Producto
class ProductoTest {

    Producto producto = new Bebida(1, "Limonada", "Natural", 10000, "5 min", 500, "5C",
            EstadoBebida.FRIA, PreparacionEspecial.NO);

    @Test
    void calcularPrecioVenta() {
        assertEquals(11000, producto.calcularPrecioVenta(), 0.01);
    }

    @Test
    void verificarCalidad() {
        assertTrue(producto.verificarCalidad());
    }
}