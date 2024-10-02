import controller.Coleccion;
import model.*;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Coleccion coleccion = new Coleccion();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;


        do {

            System.out.println("1. Añadir");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Borrar");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Elemento elemento = null;
                    System.out.println("Te dispones a anadir. Que quieres anadir");
                    System.out.println("1. Audios");
                    System.out.println("2. Libros");
                    System.out.println("3. Video");
                    int opcionAnadir = scanner.nextInt();
                    System.out.println("Introduce datos");
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("titulo");
                    String titulo = scanner.next();
                    System.out.println("nombre");
                    String nombre = scanner.next();
                    System.out.println("dni");
                    String dni = scanner.next();
                    System.out.println("tamanio");
                    int tamanio = scanner.nextInt();
                    System.out.println("formato");
                    String formato = scanner.next();
                    switch (opcionAnadir) {
                        case 2:
                            String isbn = scanner.next();
                            int nPaginas = scanner.nextInt();
                            elemento = new Libro(id, titulo, new Persona(nombre, dni), tamanio, formato, isbn, nPaginas);
                            break;
                        case 1:
                            int duracion = scanner.nextInt();
                            String soporte = scanner.next();
                            elemento = new Audio(id, titulo, new Persona(nombre, dni), tamanio, formato, duracion, soporte);
                            break;
                        case 3:
                            String nombreDirector = scanner.next();
                            String dniDirector = scanner.next();
                            String nombreActor = scanner.next();
                            String dniActor = scanner.next();

                            elemento = new Video(id, titulo, new Persona(nombre, dni), tamanio, formato,
                                    new Persona(nombreDirector, dniDirector), new Persona[]{new Persona(nombreActor, dniActor)});

                            break;
                    }
                    coleccion.anadirElementos(elemento);
                    break;
                case 2:
                    coleccion.listarElementos();
                    break;
                case 3:
                    System.out.println("Por que director queres buscar");
                    String nombreDirector = scanner.next();
                    coleccion.buscarDirector(nombreDirector);
                    break;
                case 4:
                    System.out.println("Que id quieres buscar");
                    int idBorrar = scanner.nextInt();
                    coleccion.eliminarElemento(idBorrar);
                    break;
            }

        } while (opcion != 5);


    }
}
