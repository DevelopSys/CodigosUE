import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EntradaFichero {


    public static void main(String[] args) {
        File file = new File("ejercicio2.txt");
        FileWriter fileWriter =null;
        try {
            fileWriter = new FileWriter(file);
            String mensaje = "El serial version uid para poder leer los objetos que están guardados en el fichero es de 987L. Ademas, los objetos tendran una estructura de nombre, apellido, telefono y edad (definida la clase dentro de un paquete llamado model)";
            for (int i=0;i<mensaje.length();i++){
                int codigo = (int)mensaje.charAt(i)*4;
                fileWriter.write(codigo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
