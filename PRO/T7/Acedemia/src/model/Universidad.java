package model;

import java.util.ArrayList;

public class Universidad {

    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Profesor> listaProfesores;

    public Universidad() {
        this.listaAlumnos = new ArrayList<>();
        this.listaProfesores = new ArrayList<>();
        listaProfesores.add(new Profesor());
    }

    public void contratarProfesor(Profesor profesor) {
        listaProfesores.add(profesor);
    }

    public void matricularAlumno(Alumno alumno) {
        this.listaAlumnos.add(alumno);
    }

    public void mostrarAlumnos() {
        // [ Juan, Maria, Luis, Claudia]
        for (Alumno item : listaAlumnos) {
            item.mostrarDatos();
            //System.out.println(item.getNombre());
        }
    }

    public void calificarAlumnos() {
        // Cuando se puede calificar alumnos???
        if (listaProfesores.size() == 0 || listaAlumnos.size() == 0) {
            System.out.println("No hay elementos suficientes para ejecutar");
        } else {
            System.out.println("Calificando");
            for (Alumno alumno : listaAlumnos) {
                listaProfesores.get(0).ponerNotas(alumno);
            }
        }

    }

    public void mostrarAprobados() {
        // mostrar los datos de los alumnos con todas aprobadas
        for (Alumno item : listaAlumnos) {
            if (item.getAsignatura1().getCalificacion() >= 5 && item.getAsignatura2().getCalificacion() >= 5
                    && item.getAsignatura3().getCalificacion() >= 5) {
                item.mostrarDatos();
            }
        }
    }
}
