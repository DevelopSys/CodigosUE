package ejercicio1;

import ejercicio1.controller.Colegio;
import ejercicio1.model.Alumno;

public class Entrada {

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Alumno 1","Apellido 1", "1234A");
        Alumno alumno2 = new Alumno("Alumno 2","Apellido 2", "1234B");
        Alumno alumno3 = new Alumno("Alumno 3","Apellido 3", "1234C");
        Alumno alumno4 = new Alumno("Alumno 4","Apellido 4", "1234D");

        Colegio colegio = new Colegio();

        colegio.darAlta(alumno1);
        colegio.darAlta(alumno2);
        colegio.darAlta(alumno3);
        colegio.darAlta(alumno4);

        colegio.calificarAlumno(1,5.6);
        colegio.calificarAlumno(2,6.7);
        colegio.calificarAlumno(3,7.9);
        colegio.calificarAlumno(4,1.6);

        colegio.listarAlumnos();
    }

}
