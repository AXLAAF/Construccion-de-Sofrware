public class Usuario {
    private String nombreUsuario; 
    private String correoUsuario; 
    private int idUsuario; 

    public void mostrarUsuario() { 
        System.out.println("Usuario: " + nombreUsuario); 
        System.out.println("Correo: " + correoUsuario); 
        System.out.println("ID: " + idUsuario); 
    }
}