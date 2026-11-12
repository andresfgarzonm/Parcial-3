package model;

import java.util.List;

public class Cliente {
    private String numeroDocumento;
    private String nombreCompleto;
    private int telefono;
    private String correoElectronico;
    private String direccionResidencia;

    private List<Pedido> listClientePedidos;

    /**
     * Metodo constructor cliente
     * @param numeroDocumento
     * @param nombreCompleto
     * @param telefono
     * @param correoElectronico
     * @param direccionResidencia
     */
    public Cliente(String numeroDocumento, String nombreCompleto, int telefono, String correoElectronico, String direccionResidencia, List<Pedido> listClientePedidos) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.listClientePedidos = listClientePedidos;
    }

    /**
     * getters y setter cliente
     * @return
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public List<Pedido> getListClientePedidos() {
        return listClientePedidos;
    }

    public void setListClientePedidos(List<Pedido> listClientePedidos) {
        this.listClientePedidos = listClientePedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroDocumento='" + numeroDocumento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono=" + telefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                ", listClientePedidos=" + listClientePedidos +
                '}';
    }
}
