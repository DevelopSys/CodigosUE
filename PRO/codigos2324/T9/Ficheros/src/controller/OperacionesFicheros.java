package controller;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class OperacionesFicheros {

    public void lecturaInformacion() {
        // obtener informacion sobre un fichero
        File file = new File("src/resources");
        // nombre, ruta, puedo leerlo, existe
        /*System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.exists());*/
        /*if (!file.exists()){
            // crearlo
            System.out.println("Entrando");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Fallo en la creacion del fichero");
            }
        }*/
        /*if (!file.exists()){
            file.mkdir();
        }*/
        if (file.isDirectory()) {
            // saca todos los nombre que tienes dentro
            /*String[] nombres = file.list();
            for ( String nombre : nombres){
                System.out.println(nombre);
            }*/

            // saca todos los ficheros que tienes dentro
            File[] ficheros = file.listFiles();
            for (File fichero : ficheros) {
                if (fichero.isDirectory()) {
                    System.out.println("ESTO ES UN DIRECTORIO");
                }
                System.out.println(fichero.getName());
            }
        }

    }

    public void lecturaFichero() {
        File file = new File("src/resources/ejemplos/lectura.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            // leo (linea a linea) readLine()
            // leo (caracter a caracter) read()
            // leer el fichero de forma completa -> hasta que codigo sea -1
            /*int codigo = -1;
            while ( (codigo = fileReader.read()) != -1 ){
                System.out.print((char) codigo);
            }*/
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("El fichero no se puede leer");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }
    }

    public void escrituraFichero() {

        // File - FileWriter - PrintWriter

        File file = new File("src/resources/ejemplos/escritura.txt");
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            //fileWriter.write("Esto es una frase para poder tener algo escrito\n");
            //fileWriter.write("Esto es la segundo linea\n");
            printWriter.println("Esto es una frase con printw");
            printWriter.println("Esto es la segunda frase");

        } catch (IOException e) {
            System.out.println("Error en la escritura");
        } finally {
            try {
                fileWriter.close();
                printWriter.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }


    }

    public void escrituraObjeto() {
        //  ObjectOutputStream -> FileOutputStream -> File

        ObjectOutputStream objectOutputStream = null;
        File file = new File("src/resources/ejemplos/usuarios1.obj");

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            ArrayList<Usuario> listaUsuarios = new ArrayList();
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            listaUsuarios.add(new Usuario("Borja", "Martin", 23, "Madrid"));
            //objectOutputStream.writeObject(new Usuario("Borja", "Martin", 23, "Madrid"));
            objectOutputStream.writeObject(listaUsuarios);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }

    }

    public void lecturaObjecto() {
        //  ObjectInputStream -> FileInputStream -> File
        ObjectInputStream objectInputStream = null;
        File file = new File("src/resources/ejemplos/usuarios1.obj");

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Usuario usuario = (Usuario) objectInputStream.readObject();
            System.out.println(usuario); // model.Usuario@123da4 -> HEXADECIMAL
        } catch (IOException e) {
            System.out.println("error en la lectura");
        } catch (ClassCastException e) {
            System.out.println("Error en el casteo de la clase");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            } finally {
                System.out.println("Cerrado a nulo");
            }
        }

    }
}
