import model.Usuario;

import java.io.*;

public class GestionFicheros {


    public void trabajoFicherosBase() {
        // FILE -> ruta (absolutas o relativas)
        // WINDOWS -> C:\\asasd\\asdasd\\asdasd
        // fisico y logico
        File file = new File("src/resources/ejemplo1.txt");
        // logico
        File carpeta = new File("src/resources/ficheros");
        if (!file.exists()) {
            // CREARLO
            try {
                file.createNewFile(); // logico -> fisico
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.canRead());
                System.out.println(file.canWrite());
                System.out.println(file.isFile());
                System.out.println(file.isHidden());
            } catch (IOException e) {
                System.out.println("Error en la creacion del fichero");
            }

        }
        if (!carpeta.exists()) {
            // excepcion IO no por:
            carpeta.mkdir();
        }

        // carpeta.list();  // String[] nombre de los ficheros que estan dentro
        /*for ( String item : carpeta.list() ) {
            System.out.println(item);
        }*/
        // carpeta.listFiles() // File[] ficheros que estan dentro
        // System.out.println(carpeta.list()[1]);
        /*for ( File item : carpeta.listFiles() ) {
            System.out.println(item.getName());
        }*/

        // sacar el nombre de todas las carpetas y ficheros de una ruta
        // de forma RECURSIVO -> hasta que no encuentre mas carpetas
        File carpetaCodigosUE = new File("/Users/borja/Documents/GitHub/CodigosUE");
        for (File item : carpetaCodigosUE.listFiles()) {
            if (!item.isHidden()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName());
                    for (File item2 : item.listFiles()) {
                        System.out.println("\t" + item2.getName());
                        // cuando hago otro recorrido: CARPETA

                    }
                } else {
                    System.out.println(item.getName());
                }

            }
        }

    }

    public void flujoEscritura(String path) {
        // File -> FileWriter -> BufferedWriter
        // File -> FileWriter -> PrintWriter

        File file = new File(path);

        // FileWriter fw = null;
        // BufferedWriter bf = null;
        PrintWriter pw = null;

        try {
            // si no encuentra la ruta -> lo creo createNewFile() -> FileNotFoundException
            /*fw = new FileWriter(file);
            fw.write("234\n");
            fw.write("Esto es otra linea");*/
            /*bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(123);
            bf.newLine();
            bf.write(234);*/
            pw = new PrintWriter(new FileWriter(file, true));
            pw.println("Esto es una linea nueva en el fichero");
            pw.println("Esto es otra linea nueva en el fichero");


        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        } finally {
            try {
                pw.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cerrado fichero");
            }
        }

    }

    public void flujoLectura(String path) {
        // File -> FileReader (caracter a caracter)-> BufferedReader (linea a linea)
        File file = new File(path);
        // FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {

            // {{{
            /*fileReader = new FileReader(file);
            int numeroASCI = -1; // numero ASCI del caracter leido
            while ((numeroASCI = fileReader.read())>-1){
                System.out.println((char) numeroASCI);
            }*/
            /*System.out.println(numeroASCI);
            numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            System.out.println(numeroASCI);
            numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            System.out.println(numeroASCI);
            numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            System.out.println(numeroASCI);
            numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            System.out.println(numeroASCI);
            numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            System.out.println(numeroASCI);*/
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea =null;
            while ((linea =  bufferedReader.readLine())!=null){
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void flujoEscrituraObjetos(String path){
        // File -> FileOutputStream -> ObjectOutpStream
        File file = new File(path);
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new Usuario("Borja","Martin","correo@ue.com",12312));
            oos.writeObject(new Usuario("Juan","Gomez","juan@ue.com",232323));
            // Usuario@23DF2 -> N A C T
        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

}
