package controller;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OperacionesFicheros {

    public void crearFichero() {
        File fichero = new File("src/resources/ejemplo.txt");
        // existe, nombre, esdeLectura, esdeEscritura, tamano, esFichero
        // System.out.println(fichero.exists());
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en la creacion del fichero");
            }

        }
    }

    public void crearDirectorio() {
        File fichero = new File("src/resources/procesos/escritura");
        // existe, nombre, esdeLectura, esdeEscritura, tamano, esFichero
        // System.out.println(fichero.exists());
        if (!fichero.exists()) {
            fichero.mkdirs(); // crea la carpeta
        }

    }

    public void obtenerInformacion(String path) {
        File file = new File(path);
        String nombre = file.getName();
        boolean fichero = file.isFile();
        String ruta = file.getAbsolutePath();
        // lectura R -> 4
        // escritura W -> 2
        // ejecucion X -> 1
        // chomod 777
        boolean permisoLectura = file.canWrite();
        File parent = file.getParentFile();
        System.out.println("Nombre: " + nombre);
        System.out.println("Es fichero: " + fichero);
        System.out.println("Ruta: " + ruta);
        System.out.println("Lectura: " + permisoLectura);
        System.out.println("Perent: " + parent.getAbsolutePath());
        System.out.println("Existe: " + file.exists());
    }

    public void listarFicheros(String path) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            System.out.println("Sacando los elementos que tiene dentro");
            // sacar la lista de nombres (string)
            // String[] ficheros = file.list();
            File[] ficheros = file.listFiles();
            for (File fichero : ficheros) {
                // obtenerInformacion(fichero.getAbsolutePath());
                System.out.println(fichero.getName());
                if (fichero.isDirectory() && !fichero.isHidden()) {
                    listarFicheros(fichero.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No puedo procesar la peticion");
        }
    }

    public void realizarEscritura(String path){
        // 1 crea el file asociado
        File file = new File(path);
        // 2 creo el modo escritura
        FileWriter fileWriter = null;

        // 3 lo inicializo
        try {
            fileWriter = new FileWriter(file);
            // 5 escrito lo que quiera dentro del fichero
            char letra = 'j';
            // quiero guardar el 97 (codigo asociado a la a)
            int codigo = letra; // 97
            fileWriter.write(String.valueOf(codigo));


        } catch (IOException e) {
            System.out.println("Error en la I/O del fichero");
        } finally {
            // 4 Cierro el flujo de datos
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException  e) {
                System.out.println("Error en el cerrado del flujo");
            }
        }

        // existe? -> excepcion

    }

}
