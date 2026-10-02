// ERROR: sin Javadoc de clase.
// ERROR: nombre genérico ("Procesador" no describe qué procesa).
public class ProcesadorOriginal {
// ERROR: sin Javadoc (propósito, @param).
// ERROR: nombre genérico ("procesar" no indica la operación realizada).
// ERROR: viola el Principio de Responsabilidad Única (calcula e imprime en consola).
// ERROR: no valida que "datos" sea null.
    public static void procesar(int[] datos) {
// ERROR: inicialización previa innecesaria y dispersa; mejor declarar dentro del ciclo.
        int i = 0;
        int suma = 0;
// ERROR: estructura while inadecuada para iterar arreglos indexados; debe usarse for o for-each.
        while (i < datos.length) {
// ERROR: acumula el valor en suma antes de verificar si es negativo; no omite los negativos.
            suma += datos[i];
            if (datos[i] < 0) {
// ERROR: cadena literal dispersa sin constante.
                System.out.println("Valor negativo encontrado, se omite");
// ERROR: "continue" salta antes del incremento "i++", provocando un ciclo infinito.
                continue;
            }
            i++;
        }
// ERROR: cadena literal dispersa sin constante.
        System.out.println("Suma total: " + suma);
    }

// ERROR: sin Javadoc.
    public static void main(String[] args) {
// ERROR: números mágicos sin constantes y sin pruebas de casos frontera (null, vacío, negativos).
        int[] datos = {5, 10, -3, 8};
// ERROR: ejecuta método con efectos secundarios sin validar ni assertar el resultado esperado.
        procesar(datos);
    }
}
