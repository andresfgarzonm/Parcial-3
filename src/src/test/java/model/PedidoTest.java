package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    PlatoFuerte plato = new PlatoFuerte(101, "Bandeja", "Tradicional", 25000, "20 min", 500,
            TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO);   // vale 30000

    @Test
    void valorTotalProductosSolicitados() {
        Pedido pedido = new Pedido(1, "2026-11-12", "Regular", EstadoPedido.CONFIRMADO,
                ModalidadEntrega.CONSUMO_RESTAURANTE, null, null, 0);
        pedido.getDetalles().add(new DetallePedido(plato, 2));

        assertEquals(60000, pedido.valorTotalProductosSolicitados(), 0.01);   // 30000 * 2
    }

    @Test
    void calcularValorTotalPedido() {
        Pedido pedido = new Pedido(1, "2026-11-12", "Regular", EstadoPedido.CONFIRMADO,
                ModalidadEntrega.DOMICILIO, null, new EntregaSegura(), 10);
        pedido.getDetalles().add(new DetallePedido(plato, 1));

        assertEquals(50000, pedido.calcularValorTotalPedido(), 0.01);   // 30000 + 20000 de domicilio
    }
}