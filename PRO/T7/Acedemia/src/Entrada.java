import model.Alumno;
import model.Asignatura;
import model.Profesor;
import model.Universidad;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {

        // CENTRO ESCOLAR = [1.2,3,4,5,6,7,8,9]
        //
        Asignatura programacion = new Asignatura(1);
        Asignatura lenguajeMarcas = new Asignatura(2);
        Asignatura sistemas = new Asignatura(3);
        Asignatura baseDatos = new Asignatura(4);
        Asignatura fol = new Asignatura(5);

        //Alumno alumno1 = new Alumno(programacion,lenguajeMarcas, sistemas);
        Alumno alumno1 = new Alumno("Juan",1,2, 3);
        // pro (1,0.0), si (3,0.0), lm (2,0.0)
        Alumno alumno2 = new Alumno("Maria",4,5, 6);
        // pro, fol, si
        Alumno alumno3 = new Alumno("Luis", 1, 2, 3);
        // (6,0.0) (7,0.0) (8,0.0)
        Alumno alumno4 = new Alumno("Claudia",new Asignatura(1), new Asignatura(2), new Asignatura(3));

        Universidad universidad = new Universidad();

        universidad.contratarProfesor(new Profesor());

        universidad.calificarAlumnos();

        // conjunto de alumnos [0]
        universidad.matricularAlumno(alumno1);
        // conjunto de alumnos [alumno1]
        universidad.matricularAlumno(alumno2);
        // conjunto de alumnos [alumno1, alumno2]
        universidad.matricularAlumno(alumno3);
        // conjunto de alumnos [alumno1, alumno2, alumno3]
        universidad.matricularAlumno(alumno4);
        // conjunto de alumnos [alumno1, alumno2, alumno3, alumno4]
        universidad.calificarAlumnos();
        universidad.mostrarAlumnos();
        System.out.println("Sacando solo aprobados");
        universidad.mostrarAprobados();




        // array?: coleccion datos, los tipos tienen que tener algo en comun, no son dinamicos. tamaño de 10
        // no hacerlo crecer ni hacerlo decrecer, asociados a posiciones
        // int[] numeros = new int[]{1,213,123,12,312,31,0} -> numeros
        // Obejet[] cosas = new Objetct[]{1,213,123,12,312,31,23, false, true, null} -> Object

        // Lista de datos dinamica (puede crecer y puede decrecer). Asocian a posiciones [123,123,123,123]

        /*
        ArrayList<Integer> listaNumeros = new ArrayList(); // [6,8,7,1]
        // añadir elemento
        listaNumeros.add(6);
        listaNumeros.add(8);
        listaNumeros.add(7);
        listaNumeros.add(1);
        // borrar elemento
        listaNumeros.remove(2); // [6,8,1]
        //listaNumeros.remove(); // [6,8,1]
        // obtener un elemento
        //listaNumeros.get(2);
        /*for ( Integer x : listaNumeros ) {
            System.out.println(x);
        }*/
        /*for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.println(listaNumeros.get(i));
        }*/
        //listaNumeros.set(1,4);
        /*for ( Integer x : listaNumeros ) {
            System.out.println(x);
        }*/


        /*Profesor borja = new Profesor();
        borja.ponerNotas(alumno1);
        alumno1.mostrarDatos();
        alumno2.mostrarDatos();
        alumno3.mostrarDatos();*/


    }
}
