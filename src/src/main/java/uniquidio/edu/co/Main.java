package uniquidio.edu.co;
import model.*;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // 1. Restaurante y Cliente base
        ElBuenComer elBuenComer = new ElBuenComer("900.123", "El Buen Comer", "Armenia");
        Cliente cliente = new Cliente("123", "Carlos Pérez", "3100000", "c@mail.com", "Armenia");

        // Producto inicial de prueba en la lista del menú
        elBuenComer.agregarProductoMenu(new PlatoFuerte(101, "Bandeja Paisa", "Tradicional", 25000, "20 min", 500, TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO));

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
                // Ver menú utilizando ciclo tradicional y .size()
                if (elBuenComer.getListaMenu().size() == 0) {
                    JOptionPane.showMessageDialog(null, "El menú está vacío.");
                } else {
                    for (Producto p : elBuenComer.getListaMenu()) {
                        JOptionPane.showMessageDialog(null, p);
                    }
                }

            } else if (opcion == 2) {
                // Submenú para elegir qué tipo de producto registrar
                String tipoProd = JOptionPane.showInputDialog("¿Qué desea registrar?\n1. Plato Fuerte\n2. Bebida\n3. Postre");
                if (tipoProd != null) {
                    int tipo = Integer.parseInt(tipoProd);
                    if (tipo == 1) {
                        elBuenComer.agregarProductoMenu(new PlatoFuerte(901,
                                JOptionPane.showInputDialog("Nombre del plato:"),
                                "Plato fuerte",
                                Integer.parseInt(JOptionPane.showInputDialog("Precio base ($):")),
                                "15 min",
                                Integer.parseInt(JOptionPane.showInputDialog("Peso (g):")),
                                TipoPreparacion.ASADO, EstadoCoccion.APROBADA, ControlCoccion.SUPERADO
                        ));
                        JOptionPane.showMessageDialog(null, "¡Plato fuerte agregado al menú!");
                    } else if (tipo == 2) {
                        elBuenComer.agregarProductoMenu(new Bebida(
                                902,
                                JOptionPane.showInputDialog("Nombre de la bebida:"),
                                "Bebida",
                                Integer.parseInt(JOptionPane.showInputDialog("Precio base ($):")),
                                "5 min",
                                Integer.parseInt(JOptionPane.showInputDialog("Volumen (ml):")),
                                Double.parseDouble(JOptionPane.showInputDialog("Temperatura (°C):")),
                                EstadoBebida.FRIA, PreparacionEspecial.NO
                        ));
                        JOptionPane.showMessageDialog(null, "¡Bebida agregada al menú!");
                    } else if (tipo == 3) {
                        elBuenComer.agregarProductoMenu(new Postre(
                                903,
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
                // Registrar Cliente
                String doc = JOptionPane.showInputDialog("Número de documento:");
                String nombre = JOptionPane.showInputDialog("Nombre completo:");
                String tel = JOptionPane.showInputDialog("Teléfono:");
                String correo = JOptionPane.showInputDialog("Correo electrónico:");
                String dir = JOptionPane.showInputDialog("Dirección de residencia:");

                cliente = new Cliente(doc, nombre, tel, correo, dir);
                JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito: " + cliente.getNombreCompleto() + "!");

            } else if (opcion == 4) {
                // Registrar y Confirmar Pedido
                JOptionPane.showMessageDialog(null, "Registrando pedido para el cliente: " + cliente.getNombreCompleto());
                if (elBuenComer.getListaMenu().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay productos en el menú para armar un pedido.");
                } else {
                    Producto productoPedido = elBuenComer.getListaMenu().get(0);
                    Pedido nuevoPedido = new Pedido(1, cliente, productoPedido);

                    elBuenComer.getListaPedidos().add(nuevoPedido);
                    cliente.getHistorialPedidos().add(nuevoPedido);

                    JOptionPane.showMessageDialog(null, "¡Pedido creado y confirmado con éxito!\nProducto: " + productoPedido.getNombre());
                }

            } else if (opcion == 5) {
                // Consultar y Actualizar Pedidos
                if (elBuenComer.getListaPedidos().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay pedidos registrados en el restaurante.");
                } else {
                    for (Pedido ped : elBuenComer.getListaPedidos()) {
                        String estadoActual = JOptionPane.showInputDialog(null,
                                "Pedido ID: " + ped.getIdPedido() + "\n" +
                                        "Cliente: " + ped.getCliente().getNombreCompleto() + "\n" +
                                        "¿Desea actualizar este pedido? (Escriba el nuevo estado o deje vacío)");

                        if (estadoActual != null && !estadoActual.equals("")) {
                            JOptionPane.showMessageDialog(null, "¡Pedido actualizado correctamente!");
                        }
                    }
                }

            } else if (opcion == 6) {
                // Consultar las ventas del restaurante
                int totalPedidos = elBuenComer.getListaPedidos().size();
                JOptionPane.showMessageDialog(null, "VENTAS DEL RESTAURANTE\n" +
                        "Total de pedidos realizados: " + totalPedidos + "\n" +
                        "Restaurante ubicado en: Armenia, Quindío");

            } else if (opcion == 7) {
                // Verificar calidad de los productos del menú
                if (elBuenComer.getListaMenu().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay productos para verificar.");
                } else {
                    for (Producto p : elBuenComer.getListaMenu()) {
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
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 8);
    }
}