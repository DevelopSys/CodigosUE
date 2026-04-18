import exception.SaldoException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        boolean fallo = false;
        do {
            try {
                //4000
                gestor.sacarDinero();
                fallo = false;
            } catch (SaldoException e) {
                System.out.println(e.getMessage());
                fallo = true;
            }
        } while (fallo);


        try {
            gestor.lanzarExcepcion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            gestor.obtenerLetrasNombre();
        } catch (Exception e) {
            System.out.println("El nombre viene en vacio");
        }


        try {
            gestor.obtenerAsignaturaFav();
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Error en el dato introducido");
        }
        /*String nombre = "Borja";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ejecutando el programa");
        String[] asignaturas = {"Programacion", "Lenguaje de Marcas", "Sistemas", "Fundamentos"};
        try {
            System.out.println("Mi nombre tieneun numero de letras de " + nombre.length());
            System.out.println("De todas las asignaturas del ciclo indica la que mas te gusta");
            int posicion = scanner.nextInt();
            String asignatura = asignaturas[posicion];
            System.out.println("Tu asignatura favorita es " + asignatura);
        } catch (NullPointerException e) {
            System.out.println("La variable es nula");
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Error con el dato indicado");
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
        System.out.println("Terminando el programa");
        File file = new File("src/main/java/lectura.txt");
        try {
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/

    }
}
