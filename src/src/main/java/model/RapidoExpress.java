package model;

        public class RapidoExpress implements Empresa {

        private static final int TARIFA_BASE = 5000;
        private EstadoServicio estadoServicio;


            /**
             * metodo verificar acepatacion empresa rapido express
             * @param distanciaKm
             * @return
             */
            public EstadoServicio verificarAceptacion(double distanciaKm) {
            if (distanciaKm > 0 && distanciaKm <= 12) {
                return EstadoServicio.APROBADO;
            }
            return EstadoServicio.RECHAZADO;
        }


            /**
             * metodo calcularCostoDomicilio empresa rapido express
             * @param distanciaKm
             * @return
             */
            public double calcularCostoDomicilio(double distanciaKm) {
            if (verificarAceptacion(distanciaKm) == EstadoServicio.RECHAZADO) {
                return 0;
            }
            return TARIFA_BASE + (1500 * distanciaKm);
        }
    }

