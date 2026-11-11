package model;

public abstract class Producto {
    protected int codigoUnico;
    protected String nombre;
    protected String descripcion;
    protected int precioBase;
    protected String tiempoPreparacion;

    //metodo contructor
    public Producto(int codigoUnico, String nombre, String descripcion, int precioBase, String tiempoPreparacion) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public abstract double calcularPrecioVenta();
    public abstract boolean verificarCalidad();

    // getters
    public int getCodigoUnico() {
        return codigoUnico;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getPrecioBase() {
        return precioBase;
    }
    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    // setters
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}