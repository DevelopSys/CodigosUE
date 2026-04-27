import model.User;

import javax.swing.plaf.PanelUI;
import java.io.*;

public class GestorFicheros {

    // CUIDADO CON LOS FLUJOS
    // File -> solo para textos planos .txt
    // inputs -> FileReader (int a int) -> BufferedReader (String a String)
    // output -> FileWriter (caracter a caracter) -> BufferWriter o PrintWriter

    public void crearFichero(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        File file1;
        FileWriter fileWriter; // caracter a caracter
        BufferedWriter bufferedWriter; // escribe linea a linea
    }
    public void lecturaFichero(String path) {
        // File -> FileReader (int a int) -> BufferedReader
        File file = new File(path);
        // existe el fichero?
        FileReader reader = null;

        try {
            reader = new FileReader(file);
            int codigo = -1;
            while ((codigo = reader.read()) != -1) {
                System.out.print((char) codigo);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error en los permisos");
        } finally {
            try {
                reader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }
    public void lecturaFicheroLinea(String path) {
        // File -> FileReader -> BufferedReader
        File file = new File(path);
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en cerrado");
            }
        }

    }
    public void escribirContenido(String path) {
        // File -> FileWriter -> escribo caracter a caracter
        File file = new File(path);

        FileWriter writer = null;

        try {
            writer = new FileWriter(file,true);
            writer.write(123);
        } catch (IOException e) {
            System.out.println("Error en la escritura");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }
    public void escribirLineas(String path){
        // File -> FileWriter -> PrintWriter

        File file = new File(path);
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("Esta linea sea la primera");
            printWriter.println("Esta linea sea la segunda");
            printWriter.println("Esta linea sea la tercera");
        } catch (IOException e) {
            System.out.println("Error en escritura");
        } finally {
            try {
                // fileWriter.close();
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error en cerrado");
            }
        }
    }
    public void descifrar(String path){
        File file = new File(path);
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String linea = bufferedReader.readLine();
            String[] codigos = linea.split(" ");
            for (String item:
                 codigos) {
                int cod = Integer.parseInt(item);
                System.out.print((char) cod);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("No hay permisos de lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Fallo en cierre");
            }
        }
    }

    public void escribirObjeto(String path){
        // File -> ObjectOutputStream -> FileOutStream

        File file = new File(path);
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new User("Borja", "Martin",21,"bmartin@gmail.com"));
        } catch (IOException e) {
            System.out.println("Error en permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void lecturaObjeto(String path){
        // File -> ObjectInputStream -> FileInputStream

        File file = new File(path);
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User user = (User) ois.readObject();
            user.mostrarDatos();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("Error en cambio de tipo");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la lectura de la clase");
        } catch (ClassCastException e){
            System.out.println("Error en el casteo");
        }

        finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }
}
