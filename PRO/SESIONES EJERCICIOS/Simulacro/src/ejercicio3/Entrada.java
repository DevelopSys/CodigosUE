package ejercicio3;

import ejercicio3.model.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {
        //Estudiante estudiante1 = new Estudiante("Borja",4,6,3);
        //Estudiante estudiante2 = new Estudiante("Juan",2,7,9);
        /*
        ENTRADA DEL EJERCICIO DEL SIMULACRO
        ArrayList<Estudiante> listaEstudiantes = null;

        try {
            listaEstudiantes = Estudiante.leerEstudiante("src/ejercicio3/resources/estudiantes.txt");
            for ( Estudiante estudiante : listaEstudiantes ) {
                System.out.println(estudiante.getNombre());
                System.out.println(estudiante.getNota1());
                System.out.println(estudiante.getNota2());
                System.out.println(estudiante.getNota3());
                estudiante.caluclarMedia();
            }
        } catch (IOException | NumberFormatException | NullPointerException e1) {
            System.out.println("El fichero no se encuentra o hay un error de cambio de tipo o la lista es nula");
        }

        // listaEstudiantes.add(estudiante1);
        // listaEstudiantes.add(estudiante2);*/

        // ENTRADA DEL EJERCICIO DEL SIMULACRO MODIFICADO PARA ESCRIBIR Y LEER OBJETOS
        try {
            // Estudiante.escribirEstudiantes();
            Estudiante.leerEstudiantes();
        } catch (IOException e) {
            System.out.println("Fallo");
        } catch (ClassNotFoundException e) {
            System.out.println("Fallo de clase");
        }

    }
}
