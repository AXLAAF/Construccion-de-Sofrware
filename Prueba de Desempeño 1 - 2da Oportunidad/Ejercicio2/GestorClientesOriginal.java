import java.util.ArrayList;
import java.util.List;

// ERROR: sin Javadoc de clase.
public class GestorClientesOriginal {
// ERROR: sin Javadoc (propósito, @param).
// ERROR: no valida que "clientes" o "inactivo" sean null.
    public static void eliminarInactivos(List<String> clientes, String inactivo) {
// ERROR: modificar la lista iterando con for-each lanza ConcurrentModificationException.
        for (String cliente : clientes) {
// ERROR: "==" compara referencias de memoria, no contenido; debe usarse equals().
            if (cliente == inactivo) {
                clientes.remove(cliente);
            }
        }
    }

// ERROR: sin Javadoc.
    public static void main(String[] args) {
        List<String> clientes = new ArrayList<>();
// ERROR: literales dispersos ("Juan", "Pedro") sin constantes.
        clientes.add("Juan");
        clientes.add("Pedro");
// ERROR: "new String(...)" crea un objeto innecesario en el heap evadiendo el pool; mala práctica.
        clientes.add(new String("Pedro"));
// ERROR: literal repetido sin constante.
        eliminarInactivos(clientes, "Pedro");
// ERROR: imprime sin verificar el resultado esperado.
        System.out.println(clientes);
    }
}
