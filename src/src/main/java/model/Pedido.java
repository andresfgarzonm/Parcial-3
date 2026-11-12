package model;

public class Pedido {
    public int codigoPedido;
    public String fecha;
    public String tipoCliente;

    private EstadoPedido estadoPedido;
    private ModalidadEntrega modalidadEntrega;

    /**
     * Metodo constructor pedido
     * @param codigoPedido
     * @param fecha
     * @param tipoCliente
     * @param estadoPedido
     * @param modalidadEntrega
     */
    public Pedido(int codigoPedido, String fecha, String tipoCliente, EstadoPedido estadoPedido, ModalidadEntrega modalidadEntrega) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.tipoCliente = tipoCliente;
        this.estadoPedido = estadoPedido;
        this.modalidadEntrega = modalidadEntrega;
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

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", fecha='" + fecha + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", estadoPedido=" + estadoPedido +
                ", modalidadEntrega=" + modalidadEntrega +
                '}';
    }
}
