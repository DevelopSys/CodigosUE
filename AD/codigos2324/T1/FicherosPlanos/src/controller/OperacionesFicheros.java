package controller;

import java.io.*;
import java.util.Scanner;

public class OperacionesFicheros {

    public void lecturaDirectorios(File file){
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        //new File(file.getAbsolutePath()+"/Ejemplo").mkdirs();
        String[] listaNombres = file.list();
        for (String item : listaNombres) {
            System.out.println(item);
        }

        listarElementos(file);

        // hacer un listado recursivo de todos los directorios y ficheros de un File
    }
    private void listarElementos(File file){
        if (file.isDirectory()){
            for (File item: file.listFiles()) {
                System.out.println(item.getAbsolutePath());
                listarElementos(item);
            }
        }
    }

    public void escribirFichero() {
        // File -> FileReader o FileWriter
        File file = new File("/Users/borjam/Documents/GitHub/CodigosUE/AD/codigos2324/FicherosPlanos/src/ficheros/ejemplo.txt");
        FileWriter fileWriter=null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write("Ejemplo");
            fileWriter.write("De escritura");
            fileWriter.write("En varias lineas");
            fileWriter.write("\n");
            fileWriter.write("Otra linea");
            fileWriter.write(72);
        } catch (IOException e) {
            System.out.println("Fallo a la hora de escribir el fichero");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }




        // continuo
    }
    public void escribirFicheroBuffered() {
        // File -> FileWriter -> BufferedWriter o PrintWriter
        File file = new File("/Users/borjam/Documents/GitHub/CodigosUE/AD/codigos2324/FicherosPlanos/src/ficheros/ejemplo1.txt");
        FileWriter fileWriter=null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println("Esto es un ejemplo de escritura con printwriter");
            printWriter.println("Esto es otra linea para poder escribir");

        } catch (IOException e) {
            System.out.println("Fallo a la hora de escribir el fichero (simple)");
        } finally {
            try {
                printWriter.close();
            } catch (NullPointerException e) {
                throw new RuntimeException(e);
            }
        }




        // continuo
    }

    public void lecturaPlana(){
        // File -> FileReader
        File file = new File("/Users/borjam/Documents/GitHub/CodigosUE/AD/codigos2324/FicherosPlanos/src/ficheros/ejemplo.txt");
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int numeroLeido = -1;
            while ((numeroLeido =fileReader.read())!=-1){
                System.out.println((char)numeroLeido);
            }
            /*int numero = fileReader.read();
            System.out.println(numero);
            numero = fileReader.read();
            System.out.println(numero);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void lecturaBuffered(){
        // File -> FileReader -> BufferedFileReader
        File file = new File("/Users/borjam/Documents/GitHub/CodigosUE/AD/codigos2324/FicherosPlanos/src/ficheros/ejemplo.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea =bufferedReader.readLine())!=null){
                stringBuffer.append(linea+"\n");
            }

            System.out.println(stringBuffer.toString());

            // String linea = bufferedReader.readLine();
            // System.out.println(linea);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
