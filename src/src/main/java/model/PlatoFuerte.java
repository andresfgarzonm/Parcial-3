package model;

public class PlatoFuerte extends Producto {
    private int pesoGramos;
    private TipoPreparacion tipoPreparacion;
    private EstadoCoccion estadoCoccion;
    private ControlCoccion controlCoccion;

    /**
     * metodo constructor plato fuerte
     * @param codigoUnico
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param tiempoPreparacion
     * @param pesoGramos
     * @param tipoPreparacion
     * @param estadoCoccion
     * @param controlCoccion
     */
    public PlatoFuerte(int codigoUnico, String nombre, String descripcion, int precioBase,
                       String tiempoPreparacion, int pesoGramos, TipoPreparacion tipoPreparacion,
                       EstadoCoccion estadoCoccion, ControlCoccion controlCoccion) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.tipoPreparacion = tipoPreparacion;
        this.estadoCoccion = estadoCoccion;
        this.controlCoccion = controlCoccion;
    }

    @Override
    public double calcularPrecioVenta() {

        return this.precioBase * 1.20;
    }

    @Override
    public boolean verificarCalidad() {
        return (pesoGramos >= 200 && pesoGramos <= 900) && (estadoCoccion == EstadoCoccion.APROBADA);
    }

    /**
     * getters y setters
     * @return
     */
    public int getPesoGramos() {

        return pesoGramos;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public EstadoCoccion getEstadoCoccion() {

        return estadoCoccion;
    }

    public ControlCoccion getControlCoccion() {

        return controlCoccion;
    }


    public void setPesoGramos(int pesoGramos) {

        this.pesoGramos = pesoGramos;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {

        this.tipoPreparacion = tipoPreparacion;
    }

    public void setEstadoCoccion(EstadoCoccion estadoCoccion) {

        this.estadoCoccion = estadoCoccion;
    }

    public void setControlCoccion(ControlCoccion controlCoccion) {

        this.controlCoccion = controlCoccion;
    }

    @Override
    public String toString() {
        return "Plato Fuerte: " + nombre +
                " Descripción: " + descripcion +
                " Precio Base: $" + precioBase +
                " Precio de Venta: $" + calcularPrecioVenta() +
                " Peso: " + pesoGramos + "g";
    }
}