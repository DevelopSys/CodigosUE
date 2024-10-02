package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {
        // FILE - FILEREADER - BUFFEREDREACER

        File file = new File("src/resources/examen.txt");
        FileReader reader = null;

        try {
            reader = new FileReader(file);
            int codigo = -1;
            while ((codigo = reader.read())!= -1){
                System.out.println(codigo);
                System.out.println((char) codigo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede encontrar el fichero");
        } catch (IOException e){
            System.out.println("Error en los permisos de la lectura");
        } finally{
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado del fichero");
            } catch (NullPointerException e){
                System.out.println("Nulo en el reader");
            }
        }

    }
}
