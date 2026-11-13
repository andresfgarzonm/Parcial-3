package uniquidio.edu.co;

import model.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * 1. Restaurante y Cliente base
         */
        ElBuenComer elBuenComer = new ElBuenComer("El Buen Comer", 900123, "Armenia",
                new ArrayList<Cliente>(),
                new ArrayList<Producto>(),
                new ArrayList<Pedido>(),
                new ArrayList<Empresa>());

        Cliente cliente = new Cliente("123", "Carlos Pérez", 3100000, "c@mail.com", "Armenia",
                new ArrayList<Pedido>());
        elBuenComer.getListElBuenComerClientes().add(cliente);

        /**
         * Producto inicial de prueba en la lista del menú
         */
        elBuenComer.getListElBuenComerProductos().add(new PlatoFuerte(101, "Bandeja Paisa", "Tradicional", 25000,
                "20 min", 500, TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO));

        int opcion = 0;
        do {
            String menu = "EL BUEN COMER \n" +
                    "1. Ver Menú (Lista de Productos)\n" +
                    "2. Registrar Nuevo Producto (Plato/Bebida/Postre)\n" +
                    "3. Registrar Cliente\n" +
                    "4. Registrar y Confirmar Pedido\n" +
                    "5. Consultar y Actualizar Pedidos\n" +
                    "6. Consultar Ventas del Restaurante\n" +
                    "7. Probar Calidad de Productos\n" +
                    "8. Salir\n\n" +
                    "Elija una opción:";

            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;

            opcion = Integer.parseInt(input);

            if (opcion == 1) {
                /**
                 * Ver menú
                 */
                if (elBuenComer.getListElBuenComerProductos().size() == 0) {
                    JOptionPane.showMessageDialog(null, "El menú está vacío.");
                } else {
                    for (Producto p : elBuenComer.getListElBuenComerProductos()) {
                        JOptionPane.showMessageDialog(null, p);
                    }
                }

            } else if (opcion == 2) {
                /**
                 * Submenú para elegir qué tipo de producto registrar
                 */
                String tipoProd = JOptionPane.showInputDialog("¿Qué desea registrar?\n1. Plato Fuerte\n2. Bebida\n3. Postre");
                if (tipoProd != null) {
                    int tipo = Integer.parseInt(tipoProd);
                    /**
                     * Código único consecutivo para no repetir códigos
                     */
                    int nuevoCodigo = 101 + elBuenComer.getListElBuenComerProductos().size();

                    if (tipo == 1) {
                        elBuenComer.getListElBuenComerProductos().add(new PlatoFuerte(nuevoCodigo,
                                JOptionPane.showInputDialog("Nombre del plato:"),
                                "Plato fuerte",
                                Integer.parseInt(JOptionPane.showInputDialog("Precio base ($):")),
                                "15 min",
                                Integer.parseInt(JOptionPane.showInputDialog("Peso (g):")),
                                TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO
                        ));
                        JOptionPane.showMessageDialog(null, "¡Plato fuerte agregado al menú!");
                    } else if (tipo == 2) {
                        elBuenComer.getListElBuenComerProductos().add(new Bebida(
                                nuevoCodigo,
                                JOptionPane.showInputDialog("Nombre de la bebida:"),
                                "Bebida",
                                Integer.parseInt(JOptionPane.showInputDialog("Precio base ($):")),
                                "5 min",
                                Integer.parseInt(JOptionPane.showInputDialog("Volumen (ml):")),
                                JOptionPane.showInputDialog("Temperatura de servicio (ej: 5 °C):"), // en Bebida es String
                                EstadoBebida.FRIA, PreparacionEspecial.NO
                        ));
                        JOptionPane.showMessageDialog(null, "¡Bebida agregada al menú!");
                    } else if (tipo == 3) {
                        elBuenComer.getListElBuenComerProductos().add(new Postre(
                                nuevoCodigo,
                                JOptionPane.showInputDialog("Nombre del postre:"),
                                "Postre",
                                Integer.parseInt(JOptionPane.showInputDialog("Precio base ($):")),
                                "2 min",
                                Integer.parseInt(JOptionPane.showInputDialog("Peso (g):")),
                                Double.parseDouble(JOptionPane.showInputDialog("Temperatura (°C):")),
                                RequiereRefrigeracion.SI
                        ));
                        JOptionPane.showMessageDialog(null, "¡Postre agregado al menú!");
                    }
                }

            } else if (opcion == 3) {
                /**
                 * Registrar Cliente
                 */
                String doc = JOptionPane.showInputDialog("Número de documento:");
                String nombre = JOptionPane.showInputDialog("Nombre completo:");
                int tel = Integer.parseInt(JOptionPane.showInputDialog("Teléfono:")); // en Cliente es int
                String correo = JOptionPane.showInputDialog("Correo electrónico:");
                String dir = JOptionPane.showInputDialog("Dirección de residencia:");

                cliente = new Cliente(doc, nombre, tel, correo, dir, new ArrayList<Pedido>());
                elBuenComer.getListElBuenComerClientes().add(cliente);
                JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito: " + cliente.getNombreCompleto() + "!");

            } else if (opcion == 4) {
                /**
                 * Registrar y Confirmar Pedido
                 */
                JOptionPane.showMessageDialog(null, "Registrando pedido para el cliente: " + cliente.getNombreCompleto());
                if (elBuenComer.getListElBuenComerProductos().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay productos en el menú para armar un pedido");
                } else if (!elBuenComer.clienteEstaRegistrado(cliente)) {
                    JOptionPane.showMessageDialog(null, "El cliente no está registrado");
                } else {
                    /**
                     * Elegir producto del menú y cantidad
                     */
                    String listado = "Elija el número del producto:\n";
                    for (int i = 0; i < elBuenComer.getListElBuenComerProductos().size(); i++) {
                        Producto p = elBuenComer.getListElBuenComerProductos().get(i);
                        listado += (i + 1) + ". " + p.getNombre() + " ($" + p.calcularPrecioVenta() + ")\n";
                    }
                    int indice = Integer.parseInt(JOptionPane.showInputDialog(listado)) - 1;
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                    if (indice < 0 || indice >= elBuenComer.getListElBuenComerProductos().size()) {
                        JOptionPane.showMessageDialog(null, "Producto inválido");
                    } else {
                        Producto productoPedido = elBuenComer.getListElBuenComerProductos().get(indice);

                        Pedido nuevoPedido = new Pedido(elBuenComer.getListElBuenComerPedido().size() + 1,
                                LocalDate.now().toString(), "Particular", EstadoPedido.PENDIENTE,
                                ModalidadEntrega.CONSUMO_RESTAURANTE, cliente, null, 0);
                        nuevoPedido.getDetalles().add(new DetallePedido(productoPedido, cantidad));

                        if (elBuenComer.productosPertenecenAlMenu(nuevoPedido)
                                && elBuenComer.validarCantidadesYCalidad(nuevoPedido)) {
                            nuevoPedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
                            elBuenComer.getListElBuenComerPedido().add(nuevoPedido);
                            cliente.getListClientePedidos().add(nuevoPedido);

                            JOptionPane.showMessageDialog(null, "¡Pedido creado y confirmado con éxito!\n" +
                                    "Producto: " + productoPedido.getNombre() + "\n" +
                                    "Total: $" + nuevoPedido.calcularValorTotalPedido());
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El pedido no se pudo confirmar (cantidad inválida o el producto no cumple calidad)");
                        }
                    }
                }

            } else if (opcion == 5) {
                /**
                 * Consultar y Actualizar Pedidos
                 */
                if (elBuenComer.getListElBuenComerPedido().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay pedidos registrados en el restaurante");
                } else {
                    for (Pedido ped : elBuenComer.getListElBuenComerPedido()) {
                        String estadoNuevo = JOptionPane.showInputDialog(null,
                                "Pedido ID: " + ped.getCodigoPedido() + "\n" +
                                        "Cliente: " + ped.getCliente().getNombreCompleto() + "\n" +
                                        "Estado actual: " + ped.getEstadoPedido() + "\n" +
                                        "¿Desea actualizar este pedido? (PENDIENTE, CONFIRMADO, ENTREGADO, CANCELADO o deje vacío)");

                        if (estadoNuevo != null && !estadoNuevo.equals("")) {
                            try {
                                ped.setEstadoPedido(EstadoPedido.valueOf(estadoNuevo.trim().toUpperCase()));
                                JOptionPane.showMessageDialog(null, "¡Pedido actualizado correctamente!");
                            } catch (IllegalArgumentException e) {
                                JOptionPane.showMessageDialog(null, "Estado no válido");
                            }
                        }
                    }
                }

            } else if (opcion == 6) {
                /**
                 * Consultar las ventas del restaurante
                 */
                int totalPedidos = elBuenComer.getListElBuenComerPedido().size();
                Producto masVendido = elBuenComer.obtenerProductoMasVendido();
                String nombreMasVendido = (masVendido == null) ? "Sin ventas" : masVendido.getNombre();

                JOptionPane.showMessageDialog(null, "VENTAS DEL RESTAURANTE\n" +
                        "Total de pedidos realizados: " + totalPedidos + "\n" +
                        "Ingresos generados: $" + elBuenComer.calcularIngresosGeneradosVentas() + "\n" +
                        "Producto más vendido: " + nombreMasVendido + "\n" +
                        "Categoría de mayor ingreso: " + elBuenComer.determinarCategoriaMayorIngreso() + "\n" +
                        "Restaurante ubicado en: " + elBuenComer.getDireccion());

            } else if (opcion == 7) {
                /**
                 * Verificar calidad de los productos del menú
                 */
                if (elBuenComer.getListElBuenComerProductos().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay productos para verificar");
                } else {
                    for (Producto p : elBuenComer.getListElBuenComerProductos()) {
                        boolean resultadoCalidad = p.verificarCalidad();
                        double precioVenta = p.calcularPrecioVenta();

                        JOptionPane.showMessageDialog(null,
                                "Producto: " + p.getNombre() + "\n" +
                                        "¿Pasa control de calidad?: " + resultadoCalidad + "\n" +
                                        "Precio de Venta: $" + precioVenta
                        );
                    }
                }

            } else if (opcion == 8) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 8);
    }
}