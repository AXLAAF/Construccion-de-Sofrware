import java.util.ArrayList;
import java.util.List;

/**
 * Provee utilidades para la administracion y filtrado de listas de clientes.
 */
public class GestorClientesCorregido {

    /** Nombre de cliente utilizado como prueba para eliminación de inactivos. */
    private static final String CLIENTE_INACTIVO_PRUEBA = "Pedro";

    /** Nombre de cliente activo para pruebas. */
    private static final String CLIENTE_JUAN = "Juan";

    /**
     * Constructor privado para impedir la instanciación directa de la clase utilitaria.
     */
    private GestorClientesCorregido() {
    }

    /**
     * Remueve de la lista a todos los clientes que coincidan con el identificador inactivo.
     * Utiliza el predicado removeIf para evitar ConcurrentModificationException.
     *
     * @param clientes lista de nombres de clientes a modificar (no puede ser null)
     * @param inactivo nombre del cliente a descartar (no puede ser null)
     * @throws IllegalArgumentException si clientes o inactivo son null
     */
    public static void eliminarInactivos(List<String> clientes, String inactivo) {
        if (clientes == null || inactivo == null) {
            throw new IllegalArgumentException("La lista de clientes y el nombre inactivo no deben ser nulos.");
        }

        // removeIf itera y remueve de forma segura sin romper el iterador interno
        clientes.removeIf(cliente -> inactivo.equals(cliente));
    }

    /**
     * Punto de entrada del programa para verificar el filtrado correcto de la lista.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        List<String> clientes = new ArrayList<>();
        clientes.add(CLIENTE_JUAN);
        clientes.add(CLIENTE_INACTIVO_PRUEBA);
        clientes.add(CLIENTE_INACTIVO_PRUEBA);

        try {
            eliminarInactivos(clientes, CLIENTE_INACTIVO_PRUEBA);
            System.out.println("Clientes activos: " + clientes);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
