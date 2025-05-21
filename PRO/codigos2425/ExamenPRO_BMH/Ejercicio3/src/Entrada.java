import java.io.*;

public class Entrada {

    public static void main(String[] args) {
        // File -> FileReader caracter a caracter -> BufferedReader linea a linea
        // File -> FileWriter caracter a caracter -> PrintWriter o BufferedWriter linea a linea

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw =null;
        PrintWriter pw = null;
        File file = new File("src/resources/alumnos.txt");

        try {
            /*if (!file.exists()) {
                file.createNewFile();
            }
            // fr = new FileReader(file);
            br = new BufferedReader(new FileReader(file));
            /*int codigo = -1;
            while ((codigo = fr.read())!= -1){
                System.out.println((char) codigo);
            }

            String linea = null;
            while ((linea = br.readLine())!=null){
                System.out.println(linea);
            }*/
            // fw = new FileWriter(file, true);
            // fw.write("234 asd asd asd as d");
            // pw.println("Esta linea ya tiene salto de linea incoporado")
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write("Esto es un ejemplo de cosas");
            bw.newLine();
            bw.write("Esto es otra linea completa");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //fr.close();
                //br.close();
                //fw.close();
                bw.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
