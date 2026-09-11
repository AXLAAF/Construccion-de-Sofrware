/* Se creó una clase independiente para el modulo de préstamo
 * Tiene sus atributos privados y sus funciones 
 */

public class Prestamo {
    private String fechaPrestamo; 
    private String fechaDevolucion; 
    private double multaPorDia; 
    private int diasRetraso;

     public double calcularMulta() { 
        return multaPorDia * diasRetraso; 
    }
    public void mostrarPrestamo() { 
        System.out.println("Préstamo: " + fechaPrestamo); 
        System.out.println("Devolución: " + fechaDevolucion); 
    }

    public void aplicarMulta() { 
        double total = calcularMulta(); 
        System.out.println("Multa total: $" + total); 
    }
}