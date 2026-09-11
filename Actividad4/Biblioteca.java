
public class Biblioteca {
    public static void main(String[] args) {
        Libro libro = new Libro("El Quijote", "Miguel de Cervantes", "978-8408077947", 1605);
        Usuario usuario = new Usuario("Juan Pérez", "juan@email.com", 1);
        
        libro.mostrarLibro();
        System.out.println();
        usuario.mostrarUsuario();
    }
} 
