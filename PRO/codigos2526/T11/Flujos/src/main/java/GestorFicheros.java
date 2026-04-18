import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorFicheros {
    public void crearFichero(String path) throws IOException{
        File file = new File(path);
        file.createNewFile();
        File file1;
        FileWriter fileWriter; // caracter a caracter
        BufferedWriter bufferedWriter; // escribe linea a linea
    }
}
