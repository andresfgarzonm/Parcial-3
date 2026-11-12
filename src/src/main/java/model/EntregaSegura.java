package model;


    public class EntregaSegura implements Empresa {
        private static final int TARIFA_BASE = 7000;
        private EstadoServicio estadoServicio;


        /**
         * metodo verificaraceptacion empresa entrega segura
         * @param distanciaKm
         * @return
         */
        public EstadoServicio verificarAceptacion(double distanciaKm) {
            if (distanciaKm > 0 && distanciaKm <= 20) {
                return EstadoServicio.APROBADO;
            }
            return EstadoServicio.RECHAZADO;
        }


        /**
         * metodo calcular costo domicilio empresa entrega segura
         * @param distanciaKm
         * @return
         */
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

