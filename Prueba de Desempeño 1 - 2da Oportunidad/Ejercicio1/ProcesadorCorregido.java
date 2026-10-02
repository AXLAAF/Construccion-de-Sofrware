/**
 * Procesa arreglos de enteros para realizar cálculos sobre sus elementos.
 */
public class ProcesadorCorregido {

    /**
     * Calcula la suma de los elementos positivos de un arreglo.
     * Omite los valores negativos.
     *
     * @param datos arreglo de enteros a procesar (no debe ser null)
     * @return la suma de los valores positivos
     * @throws IllegalArgumentException si el arreglo es null
     */
    public static int sumarPositivos(int[] datos) {
        if (datos == null) {
            throw new IllegalArgumentException("El arreglo de datos no puede ser nulo.");
        }

        int suma = 0;
        for (int valor : datos) {
            if (valor < 0) {
                System.out.println("Valor negativo encontrado, se omite: " + valor);
                continue;
            }
            suma += valor;
        }
        return suma;
    }

    /**
     * Punto de entrada del programa.
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        int[] datos = {5, 10, -3, 8};

        try {
            int sumaTotal = sumarPositivos(datos);
            System.out.println("Suma total: " + sumaTotal);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
