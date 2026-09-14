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

    public void procesarPedido() {
        if (montoBase <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }

        if (tipoCliente == null) {
            System.out.println("Tipo de cliente inválido.");
            return;
        }

        double descuento = calcularDescuento();
        double costoEnvio = calcularCostoEnvio();
        double totalFinal = calcularTotal();

        if (totalFinal <= 0) {
            System.out.println("Error en la transacción.");
            return;
        }

        imprimirResumen(montoBase, descuento, costoEnvio, totalFinal);
    }

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

    public double calcularTotal() {
        return montoBase - calcularDescuento() + calcularCostoEnvio();
    }

    public void imprimirResumen(double montoBase, double descuento, double costoEnvio, double totalFinal) {
        System.out.println("=== RESUMEN DE COMPRA ===");
        System.out.println("Monto Base: $" + montoBase);
        System.out.println("Descuento Aplicado: $" + descuento);
        System.out.println("Costo de Envío: $" + costoEnvio);
        System.out.println("Total a Pagar: $" + totalFinal);
        System.out.println("Estado: APROBADO");
    }
}
