package model;

import java.util.List;

public class ElBuenComer {
    public String nombreComercial;
    public int nit;
    public String direccion;

    private List<Cliente> listElBuenComerClientes;
    private List<Producto> listElBuenComerProductos;
    private List<Pedido> listElBuenComerPedido;
    private List<Empresa> listElBuenComerEmpresas;

    /**
     * Metodo constructor clase principal el buen comer
     * @param nombreComercial
     * @param nit
     * @param direccion
     * @param listElBuenComerClientes
     * @param listElBuenComerProductos
     * @param listElBuenComerPedido
     * @param listElBuenComerEmpresas
     */
    public ElBuenComer(String nombreComercial, int nit, String direccion, List<Cliente> listElBuenComerClientes, List<Producto> listElBuenComerProductos, List<Pedido> listElBuenComerPedido, List<Empresa> listElBuenComerEmpresas) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.listElBuenComerClientes = listElBuenComerClientes;
        this.listElBuenComerProductos = listElBuenComerProductos;
        this.listElBuenComerPedido = listElBuenComerPedido;
        this.listElBuenComerEmpresas = listElBuenComerEmpresas;
    }

    /**
     * Verificar que el cliente esté registrado
     * @param clienteBuscar
     * @return
     */
    public boolean clienteEstaRegistrado(Cliente clienteBuscar) {
        if (clienteBuscar == null) {
            return false;
        }
        for (int i = 0; i < listElBuenComerClientes.size(); i++) {
            Cliente c = listElBuenComerClientes.get(i);
            if (c.getNumeroDocumento().equals(clienteBuscar.getNumeroDocumento())) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Verificar que todos los productos del pedido pertenezcan al menú
     * @param pedido
     * @return
     */
    public boolean productosPertenecenAlMenu(Pedido pedido) {
        List<DetallePedido> detalles = pedido.getDetalles();

        for (int i = 0; i < detalles.size(); i++) {
            Producto prodPedido = detalles.get(i).getProducto();
            boolean encontrado = false;

            for (int j = 0; j < listElBuenComerProductos.size(); j++) {
                Producto prodMenu = listElBuenComerProductos.get(j);
                if (prodMenu.getCodigoUnico() == prodPedido.getCodigoUnico()) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verificar cantidades > 0 y que todos cumplan condiciones de calidad
     * @param pedido
     * @return
     */
    public boolean validarCantidadesYCalidad(Pedido pedido) {
        List<DetallePedido> detalles = pedido.getDetalles();

        if (detalles.isEmpty()) {
            return false;
        }

        for (int i = 0; i < detalles.size(); i++) {
            DetallePedido detalle = detalles.get(i);

            if (detalle.getCantidad() <= 0) {
                return false;
            }

            if (!detalle.getProducto().verificarCalidad()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcular ingresos generados por ventas del restaurante (sin domicilios)
     * @return
     */
    public double calcularIngresosGeneradosVentas() {
        double ingresos = 0;

        for (int i = 0; i < listElBuenComerPedido.size(); i++) {
            Pedido p = listElBuenComerPedido.get(i);

            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO || p.getEstadoPedido() == EstadoPedido.ENTREGADO) {
                ingresos += p.valorTotalProductosSolicitados();
            }
        }
        return ingresos;
    }

    /**
     * Identificar el producto con mayor cantidad de unidades vendidas
     * @return
     */
    public Producto obtenerProductoMasVendido() {
        Producto masVendido = null;
        int maxUnidades = 0;

        for (int i = 0; i < listElBuenComerProductos.size(); i++) {
            Producto prodActual = listElBuenComerProductos.get(i);
            int unidadesVendidas = 0;

            for (int j = 0; j < listElBuenComerPedido.size(); j++) {
                Pedido p = listElBuenComerPedido.get(j);

                if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO || p.getEstadoPedido() == EstadoPedido.ENTREGADO) {
                    List<DetallePedido> detalles = p.getDetalles();
                    for (int k = 0; k < detalles.size(); k++) {
                        DetallePedido d = detalles.get(k);
                        if (d.getProducto().getCodigoUnico() == prodActual.getCodigoUnico()) {
                            unidadesVendidas += d.getCantidad();
                        }
                    }
                }
            }

            if (unidadesVendidas > maxUnidades) {
                maxUnidades = unidadesVendidas;
                masVendido = prodActual;
            }
        }
        return masVendido;
    }

    /**
     * Determinar cuál de las categorías genera mayores ingresos
     * @return
     */
    public String determinarCategoriaMayorIngreso() {
        double ingresosPlatos = 0;
        double ingresosBebidas = 0;
        double ingresosPostres = 0;

        for (int i = 0; i < listElBuenComerPedido.size(); i++) {
            Pedido p = listElBuenComerPedido.get(i);

            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO || p.getEstadoPedido() == EstadoPedido.ENTREGADO) {
                List<DetallePedido> detalles = p.getDetalles();

                for (int j = 0; j < detalles.size(); j++) {
                    DetallePedido d = detalles.get(j);
                    Producto prod = d.getProducto();
                    double subtotal = prod.calcularPrecioVenta() * d.getCantidad();

                    if (prod instanceof PlatoFuerte) {
                        ingresosPlatos += subtotal;
                    } else if (prod instanceof Bebida) {
                        ingresosBebidas += subtotal;
                    } else if (prod instanceof Postre) {
                        ingresosPostres += subtotal;
                    }
                }
            }
        }

        if (ingresosPlatos >= ingresosBebidas && ingresosPlatos >= ingresosPostres) {
            return "Platos Fuertes ($" + ingresosPlatos + ")";
        } else if (ingresosBebidas >= ingresosPlatos && ingresosBebidas >= ingresosPostres) {
            return "Bebidas ($" + ingresosBebidas + ")";
        } else {
            return "Postres ($" + ingresosPostres + ")";
        }
    }

    /**
     * getters y setters clase principal el buen comer
     * @return
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getListElBuenComerClientes() {
        return listElBuenComerClientes;
    }

    public void setListElBuenComerClientes(List<Cliente> listElBuenComerClientes) {
        this.listElBuenComerClientes = listElBuenComerClientes;
    }

    public List<Producto> getListElBuenComerProductos() {
        return listElBuenComerProductos;
    }

    public void setListElBuenComerProductos(List<Producto> listElBuenComerProductos) {
        this.listElBuenComerProductos = listElBuenComerProductos;
    }

    public List<Pedido> getListElBuenComerPedido() {
        return listElBuenComerPedido;
    }

    public void setListElBuenComerPedido(List<Pedido> listElBuenComerPedido) {
        this.listElBuenComerPedido = listElBuenComerPedido;
    }

    public List<Empresa> getListElBuenComerEmpresas() {
        return listElBuenComerEmpresas;
    }

    public void setListElBuenComerEmpresas(List<Empresa> listElBuenComerEmpresas) {
        this.listElBuenComerEmpresas = listElBuenComerEmpresas;
    }

    @Override
    public String toString() {
        return "ElBuenComer{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit=" + nit +
                ", direccion='" + direccion + '\'' +
                ", listElBuenComerClientes=" + listElBuenComerClientes +
                ", listElBuenComerProductos=" + listElBuenComerProductos +
                ", listElBuenComerPedido=" + listElBuenComerPedido +
                ", listElBuenComerEmpresas=" + listElBuenComerEmpresas +
                '}';
    }
}
