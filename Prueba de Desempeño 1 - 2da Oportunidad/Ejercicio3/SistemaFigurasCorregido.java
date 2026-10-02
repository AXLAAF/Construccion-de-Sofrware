/**
 * Contrato formal para figuras geométricas capaces de calcular su propia superficie.
 */
interface Figura {
    /**
     * Calcula el área de la figura geométrica.
     *
     * @return superficie calculada de la figura
     */
    double calcularArea();

    /**
     * Obtiene la denominación de la figura geométrica.
     *
     * @return nombre descriptivo de la figura
     */
    String getNombre();
}

/**
 * Representa una figura geométrica rectangular inmutable.
 */
class Rectangulo implements Figura {

    /** Dimensión de la base del rectángulo. */
    private final double base;

    /** Dimensión de la altura del rectángulo. */
    private final double altura;

    /**
     * Construye un rectángulo validando sus dimensiones.
     *
     * @param base dimensión de la base (debe ser mayor a cero)
     * @param altura dimensión de la altura (debe ser mayor a cero)
     * @throws IllegalArgumentException si la base o la altura son menores o iguales a cero
     */
    public Rectangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser mayores a cero.");
        }
        this.base = base;
        this.altura = altura;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularArea() {
        return base * altura;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNombre() {
        return "rectángulo";
    }
}

/**
 * Representa una figura geométrica triangular inmutable.
 */
class Triangulo implements Figura {

    /** Dimensión de la base del triángulo. */
    private final double base;

    /** Dimensión de la altura del triángulo. */
    private final double altura;

    /** Denominador constante para el cálculo del área triangular. */
    private static final double DIVISOR_AREA = 2.0;

    /**
     * Construye un triángulo validando sus dimensiones.
     *
     * @param base dimensión de la base (debe ser mayor a cero)
     * @param altura dimensión de la altura (debe ser mayor a cero)
     * @throws IllegalArgumentException si la base o la altura son menores o iguales a cero
     */
    public Triangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser mayores a cero.");
        }
        this.base = base;
        this.altura = altura;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularArea() {
        return (base * altura) / DIVISOR_AREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNombre() {
        return "triángulo";
    }
}

/**
 * Servicio encargado de coordinar la salida y visualización de figuras geométricas.
 */
public class SistemaFigurasCorregido {

    /** Prefijo de texto para reportar el cálculo de área. */
    private static final String PREFIJO_REPORTE = "Área del ";

    /** Separador de etiqueta y valor numérico. */
    private static final String SEPARADOR_REPORTE = ": ";

    /** Base estándar para instancias de prueba. */
    private static final double BASE_PRUEBA = 4.0;

    /** Altura estándar para instancias de prueba. */
    private static final double ALTURA_PRUEBA = 5.0;

    /**
     * Imprime en consola el área calculada delegando el comportamiento al polimorfismo de la figura.
     * Cumple con el Principio Abierto/Cerrado (OCP) al no requerir comprobaciones con instanceof.
     *
     * @param figura figura geométrica a procesar (no puede ser null)
     * @throws IllegalArgumentException si la figura suministrada es null
     */
    public void imprimirArea(Figura figura) {
        if (figura == null) {
            throw new IllegalArgumentException("La figura no puede ser nula.");
        }
        // Despacho polimórfico en tiempo de ejecución
        System.out.println(PREFIJO_REPORTE + figura.getNombre() + SEPARADOR_REPORTE + figura.calcularArea());
    }

    /**
     * Punto de entrada del programa para demostrar el cálculo polimórfico sin acoplamiento.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        SistemaFigurasCorregido procesador = new SistemaFigurasCorregido();

        try {
            Figura rectangulo = new Rectangulo(BASE_PRUEBA, ALTURA_PRUEBA);
            Figura triangulo = new Triangulo(BASE_PRUEBA, ALTURA_PRUEBA);

            procesador.imprimirArea(rectangulo);
            procesador.imprimirArea(triangulo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
