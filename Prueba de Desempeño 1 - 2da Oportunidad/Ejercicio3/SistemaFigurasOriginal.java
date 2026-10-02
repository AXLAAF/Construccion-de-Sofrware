// ERROR: sin Javadoc de clase.
// ERROR: clase concreta que asume la fórmula de un rectángulo; debería ser abstracta o interface.
class FiguraOriginal {
// ERROR: atributos con visibilidad pública rompen el encapsulamiento; deben ser privados.
// ERROR: falta constructor para inicializar y validar dimensiones positivas.
    public double base;
    public double altura;

// ERROR: sin Javadoc (propósito, @return).
    public double calcularArea() {
        return base * altura;
    }
}

// ERROR: sin Javadoc de clase.
// ERROR: hereda atributos públicos mutables sin control de invariantes.
class TrianguloOriginal extends FiguraOriginal {
// ERROR: falta la anotación @Override.
// ERROR: sin Javadoc.
    public double calcularArea() {
// ERROR: división entera (literal 2) en operación double; preferible usar 2.0.
        return (base * altura) / 2;
    }
}

// ERROR: sin Javadoc de clase.
// ERROR: nombre genérico ("Procesador" no describe una responsabilidad específica).
public class SistemaFigurasOriginal {
// ERROR: sin Javadoc (propósito, @param).
// ERROR: no valida que "figura" sea null.
    public void imprimirArea(FiguraOriginal figura) {
// ERROR: uso de instanceof y downcasting explícito rompe el polimorfismo y viola el principio Abierto/Cerrado (OCP).
//        debería delegar dinámicamente llamando a figura.calcularArea().
        if (figura instanceof TrianguloOriginal) {
            TrianguloOriginal t = (TrianguloOriginal) figura;
// ERROR: cadena literal dispersa sin constante.
            System.out.println("Área del triángulo: " + t.calcularArea());
        } else {
// ERROR: cadena literal dispersa sin constante.
            System.out.println("Área: " + figura.calcularArea());
        }
    }

// ERROR: sin Javadoc.
    public static void main(String[] args) {
        SistemaFigurasOriginal p = new SistemaFigurasOriginal();
// ERROR: instanciación de clase base genérica en lugar de una clase especializada Rectangulo.
// ERROR: asignación directa a atributos públicos sin constructor; permite estados inconsistentes.
// ERROR: números mágicos (4 y 5) sin constantes.
        FiguraOriginal rectangulo = new FiguraOriginal();
        rectangulo.base = 4;
        rectangulo.altura = 5;

// ERROR: números mágicos (4 y 5) sin constantes.
        TrianguloOriginal triangulo = new TrianguloOriginal();
        triangulo.base = 4;
        triangulo.altura = 5;

// ERROR: imprime sin verificar el resultado esperado.
        p.imprimirArea(rectangulo);
        p.imprimirArea(triangulo);
    }
}
