import controller.CentroEscolar;
import database.DBConnection;
import model.Alumno;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        CentroEscolar centroEscolar = new CentroEscolar();
        // centroEscolar.insertarAlumno(new Alumno("Maria", "maria@gmail.com"));
        // centroEscolar.insertarAlumno(new Alumno("Juan", "Juan@gmail.com", 123123));
        // System.out.println("La cantidad de usuarios que se han borrado es de "+centroEscolar.borrarAlumno("Borja"));
        centroEscolar.obtenerAlumnos("Luis");
    }
}
