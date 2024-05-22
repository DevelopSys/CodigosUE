package ejercicio1.controller;

import ejercicio1.model.Alumno;

import java.util.ArrayList;

public class Colegio {

    private ArrayList<Alumno> listaAlumnos;
    private int contador; // 0

    public Colegio() {
        listaAlumnos = new ArrayList<>();
    }

    public void darAlta(Alumno alumno) {
        // no hay restriccion
        // numero de matricula tiene que cambiar
        contador++;
        alumno.setnMatricula(contador);
        this.listaAlumnos.add(alumno);
    }

    public void listarAlumnos() {
        if (listaAlumnos.isEmpty()){
            System.out.println("no hay alumnos matriculados");
        } else {
            System.out.println("Listando alumnos.....");
            for ( Alumno alumno : listaAlumnos ) {
                alumno.mostrarDatos();
            }
        }
    }

    public void calificarAlumno(int matricula, double calificacion){

        Alumno alumno = null;
        for ( Alumno alumnoItem : listaAlumnos ) {
            if (alumnoItem.getnMatricula() == matricula){
                alumno = alumnoItem;
                break;
            }
        }
        if (alumno!=null){
            alumno.setCalificacion(calificacion);
        } else {
            System.out.println("No se puede calificar porque no existe");
        }
    }
}
