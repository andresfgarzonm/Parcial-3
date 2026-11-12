package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElBuenComerTest {

    List<Cliente> clientes = new ArrayList<>();
    List<Producto> menu = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();
    ElBuenComer restaurante;

    PlatoFuerte plato;   // vale 30000
    Bebida bebida;       // vale 11000

    @BeforeEach
    void setUp() {
        restaurante = new ElBuenComer("El Buen Comer", 900123, "Armenia",
                clientes, menu, pedidos, new ArrayList<>());
        plato = new PlatoFuerte(101, "Bandeja", "Tradicional", 25000, "20 min", 500,
                TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO);
        bebida = new Bebida(102, "Limonada", "Natural", 10000, "5 min", 500, "5C",
                EstadoBebida.FRIA, PreparacionEspecial.NO);
        menu.add(plato);
        menu.add(bebida);
    }

    // crea un pedido con un producto y lo guarda en la lista de pedidos
    Pedido agregarPedido(EstadoPedido estado, Producto producto, int cantidad) {
        Pedido pedido = new Pedido(1, "2026-11-12", "Regular", estado,
                ModalidadEntrega.CONSUMO_RESTAURANTE, null, null, 0);
        pedido.getDetalles().add(new DetallePedido(producto, cantidad));
        pedidos.add(pedido);
        return pedido;
    }

    @Test
    void clienteEstaRegistrado() {
        Cliente registrado = new Cliente("123", "Carlos", 3100000, "c@mail.com", "Armenia", null);
        Cliente otro = new Cliente("999", "Ana", 3200000, "a@mail.com", "Armenia", null);
        clientes.add(registrado);

        assertTrue(restaurante.clienteEstaRegistrado(registrado));
        assertFalse(restaurante.clienteEstaRegistrado(otro));
    }

    @Test
    void productosPertenecenAlMenu() {
        Postre fueraDelMenu = new Postre(999, "Flan", "Frío", 8000, "10 min", 150, 4.0,
                RequiereRefrigeracion.NO);

        assertTrue(restaurante.productosPertenecenAlMenu(agregarPedido(EstadoPedido.PENDIENTE, plato, 1)));
        assertFalse(restaurante.productosPertenecenAlMenu(agregarPedido(EstadoPedido.PENDIENTE, fueraDelMenu, 1)));
    }

    @Test
    void validarCantidadesYCalidad() {
        assertTrue(restaurante.validarCantidadesYCalidad(agregarPedido(EstadoPedido.PENDIENTE, plato, 2)));
        assertFalse(restaurante.validarCantidadesYCalidad(agregarPedido(EstadoPedido.PENDIENTE, plato, 0)));
    }

    @Test
    void calcularIngresosGeneradosVentas() {
        agregarPedido(EstadoPedido.CONFIRMADO, plato, 2);   // 60000, cuenta
        agregarPedido(EstadoPedido.CANCELADO, bebida, 5);   // cancelado, no cuenta

        assertEquals(60000, restaurante.calcularIngresosGeneradosVentas(), 0.01);
    }

    @Test
    void obtenerProductoMasVendido() {
        agregarPedido(EstadoPedido.CONFIRMADO, plato, 2);
        agregarPedido(EstadoPedido.ENTREGADO, bebida, 3);

        assertSame(bebida, restaurante.obtenerProductoMasVendido());   // 3 bebidas > 2 platos
    }

    @Test
    void determinarCategoriaMayorIngreso() {
        agregarPedido(EstadoPedido.CONFIRMADO, plato, 2);    // 60000
        agregarPedido(EstadoPedido.CONFIRMADO, bebida, 1);   // 11000

        assertTrue(restaurante.determinarCategoriaMayorIngreso().startsWith("Platos Fuertes"));
    }
}
