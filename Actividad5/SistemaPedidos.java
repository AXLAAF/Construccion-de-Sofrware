public class SistemaPedidos {

    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
        sistema.procesarPedido("CLIENTE_VIP", 1500.0, true, "MEXICO");
    }

    public void procesarPedido(String tipoCliente, double montoTotal, boolean esDiaEspecial, String destino) {
        Pedido pedido = new Pedido(tipoCliente, montoTotal, esDiaEspecial, destino);
        pedido.procesarPedido();
    }

    public void procesarPedido(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Error: El pedido no puede ser nulo.");
            return;
        }
        pedido.procesarPedido();
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
