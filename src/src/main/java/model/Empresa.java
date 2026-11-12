package model;

public interface Empresa {

        boolean aceptaEntrega(double distanciaKm);
        double calcularCostoDomicilio(double distanciaKm);
    }
}
