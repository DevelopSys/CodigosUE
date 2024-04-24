import database.DBConnection;
import model.Alumno;
import repositories.AlumnoRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Entrada {
    public static void main(String[] args) {


        /*Connection connection = DBConnection.getConnection();
        System.out.println(connection.toString());*/




        AlumnoRepository alumnoRepository = new AlumnoRepository();
        alumnoRepository.insertarAlumno(new Alumno("Borja ps", "Martin ps",
                "correo ps", 123123));
        /*alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));
        alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));
        alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));
        alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));
        alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));
        alumnoRepository.insertarAlumno(new Alumno("Borja parametro", "Martin parametro",
                "correo parametro", 123123));*/


    }
}
