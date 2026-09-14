public class Pedido {

    private final String tipoCliente;
    private final double montoBase;
    private final boolean esDiaEspecial;
    private final String destino;

    public Pedido(String tipoCliente, double montoBase, boolean esDiaEspecial, String destino) {
        this.tipoCliente = tipoCliente;
        this.montoBase = montoBase;
        this.esDiaEspecial = esDiaEspecial;
        this.destino = destino;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public boolean isEsDiaEspecial() {
        return esDiaEspecial;
    }

    public String getDestino() {
        return destino;
    }

    /**
     * Calcula el descuento aplicable según el tipo de cliente y si es día especial.
     * Aplica switch expressions para eliminar anidamientos múltiples (cohesión funcional).
     *
     * @return monto total del descuento a aplicar.
     */
    public double calcularDescuento() {
        if (tipoCliente == null) {
            return 0.0;
        }

        double descuentoBase = switch (tipoCliente.toUpperCase()) {
            case "REGULAR" -> (montoBase > 1000) ? (montoBase * 0.05) : 0.0;
            case "VIP", "CLIENTE_VIP" -> {
                if (montoBase > 2000) {
                    yield montoBase * 0.20;
                } else if (montoBase > 1000) {
                    yield montoBase * 0.15;
                } else {
                    yield montoBase * 0.10;
                }
            }
            case "NUEVO" -> 50.0;
            default -> 0.0;
        };

        double descuentoDiaEspecial = esDiaEspecial ? (montoBase * 0.05) : 0.0;
        return descuentoBase + descuentoDiaEspecial;
    }

    /**
     * Calcula el costo de envío basándose en el destino y el monto base del pedido.
     * Utiliza una estructura switch simplificada.
     *
     * @return costo correspondiente al envío.
     */
    public double calcularCostoEnvio() {
        if (destino == null) {
            return 0.0;
        }

        return switch (destino.toUpperCase()) {
            case "LOCAL" -> 50.0;
            case "NACIONAL", "MEXICO" -> (montoBase > 1500) ? 0.0 : 150.0;
            case "INTERNACIONAL" -> (montoBase > 3000) ? 100.0 : 500.0;
            default -> 0.0;
        };
    }

    /**
     * Calcula el total final a pagar por el pedido.
     *
     * @return monto base menos descuento más costo de envío.
     */
    public double calcularTotal() {
        return montoBase - calcularDescuento() + calcularCostoEnvio();
    }
}
