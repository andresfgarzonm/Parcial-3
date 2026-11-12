package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public int codigoPedido;
    public String fecha;
    public String tipoCliente;

    private EstadoPedido estadoPedido;
    private ModalidadEntrega modalidadEntrega;
    private Cliente cliente;
    private List<DetallePedido> detalles;
    private Empresa empresaDomicilio;
    private double distanciaKm;

    /**
     * Metodo constructor pedido
     * @param codigoPedido
     * @param fecha
     * @param tipoCliente
     * @param estadoPedido
     * @param modalidadEntrega
     * @param cliente
     * @param empresaDomicilio
     * @param distanciaKm
     */
    public Pedido(int codigoPedido, String fecha, String tipoCliente, EstadoPedido estadoPedido,
                  ModalidadEntrega modalidadEntrega, Cliente cliente, Empresa empresaDomicilio, double distanciaKm) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.tipoCliente = tipoCliente;
        this.estadoPedido = estadoPedido;
        this.modalidadEntrega = modalidadEntrega;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.empresaDomicilio = empresaDomicilio;
        this.distanciaKm = distanciaKm;
    }

    /**
     * Calcular Valor total de los productos solicitados
     * @return
     */
    public double valorTotalProductosSolicitados() {
        double total = 0;
        for (int i = 0; i < detalles.size(); i++) {
            DetallePedido detalle = detalles.get(i);
            double precioUnitario = detalle.getProducto().calcularPrecioVenta();
            total += precioUnitario * detalle.getCantidad();
        }
        return total;
    }

    /**
     * Valor total del pedido incluyendo domicilio cuando corresponda
     * @return
     */

    public double calcularValorTotalPedido() {
        double total = valorTotalProductosSolicitados();

        if (modalidadEntrega == ModalidadEntrega.DOMICILIO && empresaDomicilio != null) {
            if (empresaDomicilio.verificarAceptacion(distanciaKm) == EstadoServicio.APROBADO) {
                total += empresaDomicilio.calcularCostoDomicilio(distanciaKm);
            }
        }

        return total;
    }

    /**
     * getters y setters pedido
     * @return
     */
    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public ModalidadEntrega getModalidadEntrega() {
        return modalidadEntrega;
    }

    public void setModalidadEntrega(ModalidadEntrega modalidadEntrega) {
        this.modalidadEntrega = modalidadEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Empresa getEmpresaDomicilio() {
        return empresaDomicilio;
    }

    public void setEmpresaDomicilio(Empresa empresaDomicilio) {
        this.empresaDomicilio = empresaDomicilio;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", fecha='" + fecha + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", estadoPedido=" + estadoPedido +
                ", modalidadEntrega=" + modalidadEntrega +
                ", cliente=" + cliente +
                ", detalles=" + detalles +
                ", empresaDomicilio=" + empresaDomicilio +
                ", distanciaKm=" + distanciaKm +
                '}';
    }
}


