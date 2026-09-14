
public class SistemaPedidos {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.procesarPedido("CLIENTE_VIP", 1500.0, true, "MEXICO");
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
