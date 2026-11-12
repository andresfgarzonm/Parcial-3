package model;

public class DetallePedido {

        private Producto producto;
        private int cantidad;

    /**
     * Metodo constructor detalle pedido
     * @param producto
     * @param cantidad
     */
    public DetallePedido(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }

