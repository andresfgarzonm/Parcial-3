package model;

public interface Empresa {

        EstadoServicio verificarAceptacion(double distanciaKm);
        double calcularCostoDomicilio(double distanciaKm);
    }

