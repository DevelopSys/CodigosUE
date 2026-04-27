import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorFicheros gestorFicheros = new GestorFicheros();
        // gestorFicheros.lecturaFicheroLinea("src/main/java/ficheros/lectura.txt");
        //gestorFicheros.escribirLineas("src/main/java/ficheros/escritura.txt");
        // gestorFicheros.descifrar("src/main/java/ficheros/codigos.txt");
        gestorFicheros.lecturaObjeto("src/main/java/ficheros/objeto.obj");
        /*
        boolean fallo = false;
        String ruta = "src/main/java/fichero/ejemplo.txt";
        Scanner scanner = new Scanner(System.in);
        do {
            scanner = new Scanner(System.in);
            try {
                gestorFicheros.crearFichero(ruta);
            } catch (IOException e) {
                System.out.println("Indica una ruta valida");
                ruta = scanner.next();
                fallo = true;
            }
        } while (fallo);*/
    }
}
