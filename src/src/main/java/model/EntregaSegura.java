package model;


    public class EntregaSegura implements Empresa {
        private static final int TARIFA_BASE = 7000;

        @Override
        public EstadoServicio verificarAceptacion(double distanciaKm) {
            if (distanciaKm > 0 && distanciaKm <= 20) {
                return EstadoServicio.APROBADO;
            }
            return EstadoServicio.RECHAZADO;
        }

        @Override
        public double calcularCostoDomicilio(double distanciaKm) {
            if (verificarAceptacion(distanciaKm) == EstadoServicio.RECHAZADO) {
                return 0;
            }
            double costo = TARIFA_BASE + (1000 * distanciaKm);
            if (distanciaKm > 5) {
                costo += 3000;
            }
            return costo;
        }
    }

