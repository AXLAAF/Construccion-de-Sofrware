// se agregaron los metodos de las otras clases 
public class Biblioteca {
  
    public static void main(String[] args) {
        
        }
    
    public void mostrarLibro(Libro libro) {
            libro.mostrarLibro();
        }
  
    public void mostrarUsuario(Usuario usuario) {
            usuario.mostrarUsuario();
        }
  
    public void mostrarPrestamo(Prestamo prestamo) {
            prestamo.mostrarPrestamo();
        }
  
    public void aplicarMulta(Prestamo prestamo) {
            prestamo.aplicarMulta();
        }
  
    public double calcularMulta(Prestamo prestamo) {
            return prestamo.calcularMulta();
        }
}
