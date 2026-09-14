public class SistemaPedidos {

    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();

        // 1. Caso nominal solicitado en la actividad (Actividad 05)
        System.out.println("--- Caso de prueba original ---");
        sistema.procesarPedido("CLIENTE_VIP", 1500.0, true, "MEXICO");

        // 2. Casos adicionales para verificar robustez y cláusulas de guarda (Early Returns)
        System.out.println("\n--- Caso: Monto inválido ---");
        sistema.procesarPedido("VIP", -50.0, false, "LOCAL");

        System.out.println("\n--- Caso: Cliente nulo ---");
        sistema.procesarPedido(null, 1200.0, false, "LOCAL");

        System.out.println("\n--- Caso: Cliente Regular ---");
        sistema.procesarPedido("REGULAR", 2000.0, false, "NACIONAL");
    }

    /**
     * Sobrecarga de compatibilidad: Permite invocar procesarPedido con la firma original
     * creando internamente el objeto de dominio Pedido (evitando 'Data Clump').
     */
    public void procesarPedido(String tipoCliente, double montoTotal, boolean esDiaEspecial, String destino) {
        Pedido pedido = new Pedido(tipoCliente, montoTotal, esDiaEspecial, destino);
        procesarPedido(pedido);
    }

    /**
     * Orquesta el procesamiento del pedido aplicando Cláusulas de Guarda (Early Returns).
     *
     * @param pedido instancia que encapsula los datos y cálculos del pedido.
     */
    public void procesarPedido(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Error: El pedido no puede ser nulo.");
            return;
        }

        // Cláusula de guarda 1: Precondición de monto válido
        if (pedido.getMontoBase() <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }

        // Cláusula de guarda 2: Precondición de tipo de cliente válido
        if (pedido.getTipoCliente() == null) {
            System.out.println("Tipo de cliente inválido.");
            return;
        }

        // Descomposición: Delegación de cálculos a métodos de alta cohesión
        double montoBase = pedido.getMontoBase();
        double descuento = pedido.calcularDescuento();
        double costoEnvio = pedido.calcularCostoEnvio();
        double totalFinal = pedido.calcularTotal();

        // Cláusula de guarda 3: Eliminación de banderas booleanas ('aprobado == true')
        if (totalFinal <= 0) {
            System.out.println("Error en la transacción.");
            return;
        }

        // Descomposición de procedimientos (SRP): Delegar impresión al procedimiento especializado
        imprimirResumen(montoBase, descuento, costoEnvio, totalFinal);
    }

    /**
     * Procedimiento con responsabilidad única de presentar el resumen de compra en consola.
     */
    private void imprimirResumen(double montoBase, double descuento, double costoEnvio, double totalFinal) {
        System.out.println("=== RESUMEN DE COMPRA ===");
        System.out.println("Monto Base: $" + montoBase);
        System.out.println("Descuento Aplicado: $" + descuento);
        System.out.println("Costo de Envío: $" + costoEnvio);
        System.out.println("Total a Pagar: $" + totalFinal);
        System.out.println("Estado: APROBADO");
    }
}
