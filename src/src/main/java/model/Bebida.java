package model;
public class Bebida extends Producto {
    private int volumenMillilitros;
    private String temperaturaServicio;
    private EstadoBebida estadoBebida;
    private PreparacionEspecial preparacionEspecial;

    /**
     * metodo constructor bebida
     * @param codigoUnico
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param tiempoPreparacion
     * @param volumenMillilitros
     * @param temperaturaServicio
     * @param estadoBebida
     * @param preparacionEspecial
     */
    public Bebida(int codigoUnico, String nombre, String descripcion, int precioBase,
                  String tiempoPreparacion, int volumenMillilitros, String temperaturaServicio,
                  EstadoBebida estadoBebida, PreparacionEspecial preparacionEspecial) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.volumenMillilitros = volumenMillilitros;
        this.temperaturaServicio = temperaturaServicio;
        this.estadoBebida = estadoBebida;
        this.preparacionEspecial = preparacionEspecial;
    }

    /**
     * metodo calcular precio venta
     * @return
     */
    @Override
    public double calcularPrecioVenta() {
        double precio = this.precioBase * 1.10;
        if (preparacionEspecial == PreparacionEspecial.SI) {
            precio += 3000;
        }
        return precio;
    }

    @Override
    public boolean verificarCalidad() {

        return (volumenMillilitros >= 150 && volumenMillilitros <= 1500);
    }

    @Override
    public String toString() {
        return "Bebida: " + nombre +
                " Código: " + codigoUnico +
                " Descripción: " + descripcion +
                " Precio Base: $" + precioBase +
                " Tiempo: " + tiempoPreparacion +
                " Volumen: " + volumenMillilitros + "ml" +
                " Temperatura: " + temperaturaServicio +
                " Estado: " + estadoBebida +
                " Prep. Especial: " + preparacionEspecial;
    }

    /**
     * getters y setters
     * @return
     */
    public int getVolumenMillilitros() {
        return volumenMillilitros;
    }

    public String getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public EstadoBebida getEstadoBebida() {
        return estadoBebida;
    }

    public PreparacionEspecial getPreparacionEspecial() {
        return preparacionEspecial;
    }


    public void setVolumenMillilitros(int volumenMillilitros) {
        this.volumenMillilitros = volumenMillilitros;
    }

    public void setTemperaturaServicio(String temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public void setEstadoBebida(EstadoBebida estadoBebida) {
        this.estadoBebida = estadoBebida;
    }

    public void setPreparacionEspecial(PreparacionEspecial preparacionEspecial) {
        this.preparacionEspecial = preparacionEspecial;
        }
    }