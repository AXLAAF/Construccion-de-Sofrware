/* Se creó la clase usuario que contiene los métodos y atributos pertenecientes a la clase
 */
public class Usuario {
    private String nombreUsuario; 
    private String correoUsuario; 
    private int idUsuario;

    public Usuario(String nombreUsuario, String correoUsuario, int idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.idUsuario = idUsuario;
    }

    public void mostrarUsuario() { 
        System.out.println("Usuario: " + nombreUsuario); 
        System.out.println("Correo: " + correoUsuario); 
        System.out.println("ID: " + idUsuario); 
    }
}