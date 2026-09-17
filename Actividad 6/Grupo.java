import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Alumno> alumnos;
    private Profesor profesor;

    public Grupo() {
        this.alumnos = new ArrayList<>();
    }

    public Grupo(List<Alumno> alumnos, Profesor profesor) {
        this.alumnos = alumnos;
        this.profesor = profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Profesor Asignado:\n").append(profesor != null ? profesor.toString() : "Ninguno").append("\n");
        sb.append("Alumnos:\n");
        if (alumnos != null && !alumnos.isEmpty()) {
            for (Alumno alumno : alumnos) {
                sb.append("- ").append(alumno.toString()).append("\n");
            }
        } else {
            sb.append("Ninguno\n");
        }
        return sb.toString();
    }
}
