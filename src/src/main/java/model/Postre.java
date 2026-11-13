package model;


public class Postre extends Producto {
    private int pesoGramos;
    private double temperaturaAlmacenamiento;
    private RequiereRefrigeracion requiereRefrigeracion;

    /**
     * metodo constructor postre
     * @param codigoUnico
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param tiempoPreparacion
     * @param pesoGramos
     * @param temperaturaAlmacenamiento
     * @param requiereRefrigeracion
     */
    public Postre(int codigoUnico, String nombre, String descripcion, int precioBase,
                  String tiempoPreparacion, int pesoGramos, double temperaturaAlmacenamiento,
                  RequiereRefrigeracion requiereRefrigeracion) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    /**
     * metodo calcular precio venta
     * @return
     */
    public double calcularPrecioVenta() {
        double incremento = 0.15;
        if (requiereRefrigeracion == RequiereRefrigeracion.SI) {
            incremento += 0.05;
        }
        return this.precioBase * (1 + incremento);
    }

    @Override
    public boolean verificarCalidad() {

        return (pesoGramos >= 80 && pesoGramos <= 500);
    }

    @Override
    public String toString() {
        return "Postre: " + nombre +
                " Código: " + codigoUnico +
                " Descripción: " + descripcion +
                " Precio Base: $" + precioBase +
                " Tiempo: " + tiempoPreparacion +
                " Peso: " + pesoGramos + "g" +
                " Temp. Almacenamiento: " + temperaturaAlmacenamiento +
                " Requiere Refrigeración: " + requiereRefrigeracion;
    }

    /**
     * getters y setters
     * @return
     */
    public int getPesoGramos() {
        return pesoGramos;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public RequiereRefrigeracion getRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public void setTemperaturaAlmacenamiento(double temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public void setRequiereRefrigeracion(RequiereRefrigeracion requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }
}