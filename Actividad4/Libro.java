public class Libro {
    private String tituloLibro; 
    private String autorLibro; 
    private String isbnLibro; 
    private int anioPublicacion;

    public void mostrarLibro() { 
        System.out.println("Título: " + tituloLibro); 
        System.out.println("Autor: " + autorLibro); 
        System.out.println("ISBN: " + isbnLibro); 
        System.out.println("Año: " + anioPublicacion); 
    } 
}