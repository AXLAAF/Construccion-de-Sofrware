public class Menu {
    public static void mostrarInformacionGrupo(Grupo grupo) {
        System.out.println("Profesor:");
        System.out.println(grupo.getProfesor());

        System.out.println("\nLista de alumnos:");
        for (Alumno alumno : grupo.getAlumnos()) {
            System.out.println(alumno);
        }
    }

    public static void main(String[] args) {
        Grupo grupo = new Grupo();

        mostrarInformacionGrupo(grupo);
    }
}
