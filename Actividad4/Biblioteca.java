public class Biblioteca {
    public static void main(String[] args) {
        // Crear un usuario
        Usuario usuario1 = new Usuario("Juan Pérez", "juan.perez@email.com", 1001);
        System.out.println("=== INFORMACIÓN DEL USUARIO ===");
        usuario1.mostrarUsuario();
        
        System.out.println("\n=== LIBROS DISPONIBLES ===");
        // Crear varios libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-84-376-0494-9", 1967);
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", "978-84-9754-105-5", 1605);
        Libro libro3 = new Libro("El Quijote", "Miguel de Cervantes", "978-0-385-33312-0", 1605);
        
        System.out.println("\n--- Libro 1 ---");
        libro1.mostrarLibro();
        
        System.out.println("\n--- Libro 2 ---");
        libro2.mostrarLibro();
        
        System.out.println("\n--- Libro 3 ---");
        libro3.mostrarLibro();
        
        // Crear y registrar un préstamo
        System.out.println("\n=== REGISTRO DE PRÉSTAMO ===");
        Prestamo prestamo1 = new Prestamo("15/09/2026", "29/09/2026", 2.5, 5);
        prestamo1.mostrarPrestamo();
        
        // Calcular y mostrar la multa por retraso
        System.out.println("\n=== CÁLCULO DE MULTA POR RETRASO ===");
        prestamo1.aplicarMulta();
        
        // Otro préstamo sin retraso
        System.out.println("\n=== SEGUNDO PRÉSTAMO ===");
        Prestamo prestamo2 = new Prestamo("10/09/2026", "24/09/2026", 2.5, 0);
        prestamo2.mostrarPrestamo();
        prestamo2.aplicarMulta();
    }
}
