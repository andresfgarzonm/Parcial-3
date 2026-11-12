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
