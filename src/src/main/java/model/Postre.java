package model;

public class Postre extends Producto {
    private int pesoGramos;
    private String temperaturaAlmacenamiento;
    private RequiereRefrigeracion requiereRefrigeracion;

    //metodo constructor
    public Postre(int codigoUnico, String nombre, String descripcion, int precioBase,
                  String tiempoPreparacion, int pesoGramos, double temperaturaAlmacenamiento,
                  RequiereRefrigeracion requiereRefrigeracion) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    // lo dos metodos de la clase postre
    @Override
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

    //getters
    public int getPesoGramos() {
        return pesoGramos;
    }

    public String getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public RequiereRefrigeracion getRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    // setters
    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public void setTemperaturaAlmacenamiento(String temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public void setRequiereRefrigeracion(RequiereRefrigeracion requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }
}
