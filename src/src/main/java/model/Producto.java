package model;

public abstract class Producto {
    public int codigoUnico;
    public String nombre;
    public String descripcion;
    public int precioBase;
    public String tiempoPreparacion;

    /**
     * metodo constructor de producto
     * @param codigoUnico
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param tiempoPreparacion
     */
    public Producto(int codigoUnico, String nombre, String descripcion, int precioBase, String tiempoPreparacion) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoPreparacion = tiempoPreparacion;
    }
    @Override
    public String toString() {
        return "Código: " + codigoUnico +
                " Nombre: " + nombre +
                " Descripción: " + descripcion +
                " Precio Base: $" + precioBase +
                " Tiempo: " + tiempoPreparacion;
    }

    public abstract double calcularPrecioVenta();
    public abstract boolean verificarCalidad();

    /**
     * getters y setters
     * @return
     */
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