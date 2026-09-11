/* Se creó el modulo libr, con sus atributos y metodos pertenecientes a la clase
 *
 */
public class Libro {
    private String tituloLibro; 
    private String autorLibro; 
    private String isbnLibro; 
    private int anioPublicacion;

    public Libro(String tituloLibro, String autorLibro, String isbnLibro, int anioPublicacion) {
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.isbnLibro = isbnLibro;
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarLibro() { 
        System.out.println("Título: " + tituloLibro); 
        System.out.println("Autor: " + autorLibro); 
        System.out.println("ISBN: " + isbnLibro); 
        System.out.println("Año: " + anioPublicacion); 
    } 
}