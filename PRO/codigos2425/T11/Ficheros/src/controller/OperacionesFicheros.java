package controller;

import model.Usuario;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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

    public void realizarEscritura(String path) {
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
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del flujo");
            }
        }

        // existe? -> excepcion

    }

    public void encriptar(String path) {
        // File -> FileWriter -> BufferedWriter/ PrintWriter
        String mensaje = "Este mensaje lo vamos a pasar a un fichero con codigo secreto";

        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);


            for (int i = 0; i < mensaje.length(); i++) {
                // e
                char letra = mensaje.charAt(i);
                int codigo = (int) letra * 4;
                // 673
                fileWriter.write(codigo);
            }

        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Fallo en el cerrado del fichero");
            }
        }

    }

    public void desencriptar(String path) {
        // File -> FileReader -> BufferedReader
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;

            while ((linea = bufferedReader.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char letra = linea.charAt(i);
                    int codigo = (int) letra / 4;
                    System.out.print((char) codigo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta del fichero");
        } catch (IOException e) {
            System.out.println("Fallo en la lectura del fichero");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado de los datos");
            }
        }


    }

    public void descifrar(String path) {

        // tengo los codigos y como los paso a letra
        // 69 115 116 101 32
        // File -> FileReader -> BufferReader

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String item : palabras) {
                    int codigo = Integer.parseInt(item);
                    System.out.print((char) codigo);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No existe la ruta");
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

    public void importacionUsuarios(String path) {
        // File - FileReader - BufferedReader

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;

            while ((linea = bufferedReader.readLine()) != null) {
                // Lucas, Martínez, lucas.martinez@email.com
                String[] datos = linea.split(",");
                Usuario usuario = new Usuario(datos[0], datos[1].trim(), datos[2].trim());
                System.out.println("Importacion del usuario correcta");
                usuario.mostrarDatos();
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("error en el cerrado");
            }
        }


    }

    public void exportarUsuarios(String path) {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Lucas", "Martínez", "lucas.martinez@email.com"));
        usuarios.add(new Usuario("Sofía", "González", "sofia.gonzalez@email.com"));
        usuarios.add(new Usuario("Mateo", "Rodríguez", "mateo.rodriguez@email.com"));
        usuarios.add(new Usuario("Valentina", "López", "valentina.lopez@email.com"));
        usuarios.add(new Usuario("Benjamín", "Pérez", "benjamin.perez@email.com"));
        usuarios.add(new Usuario("Isabella", "Sánchez", "isabella.sanchez@email.com"));
        usuarios.add(new Usuario("Thiago", "Ramírez", "thiago.ramirez@email.com"));
        usuarios.add(new Usuario("Camila", "Torres", "camila.torres@email.com"));
        usuarios.add(new Usuario("Santiago", "Flores", "santiago.flores@email.com"));
        usuarios.add(new Usuario("Martina", "Rivera", "martina.rivera@email.com"));
        usuarios.add(new Usuario("Emilio", "Díaz", "emilio.diaz@email.com"));
        usuarios.add(new Usuario("Josefina", "Romero", "josefina.romero@email.com"));
        usuarios.add(new Usuario("Dylan", "Herrera", "dylan.herrera@email.com"));
        usuarios.add(new Usuario("Antonella", "Vargas", "antonella.vargas@email.com"));
        usuarios.add(new Usuario("Alejandro", "Castro", "alejandro.castro@email.com"));
        usuarios.add(new Usuario("Agustina", "Méndez", "agustina.mendez@email.com"));
        usuarios.add(new Usuario("Bruno", "Silva", "bruno.silva@email.com"));
        usuarios.add(new Usuario("Julieta", "Rojas", "julieta.rojas@email.com"));
        usuarios.add(new Usuario("Simón", "Ortega", "simon.ortega@email.com"));
        usuarios.add(new Usuario("Luciana", "Navarro", "luciana.navarro@email.com"));
        usuarios.add(new Usuario("Gabriel", "Molina", "gabriel.molina@email.com"));
        usuarios.add(new Usuario("Renata", "Ramos", "renata.ramos@email.com"));
        usuarios.add(new Usuario("Tomás", "Guzmán", "tomas.guzman@email.com"));
        usuarios.add(new Usuario("Emilia", "Peña", "emilia.pena@email.com"));
        usuarios.add(new Usuario("Facundo", "Soto", "facundo.soto@email.com"));
        usuarios.add(new Usuario("Catalina", "Delgado", "catalina.delgado@email.com"));
        usuarios.add(new Usuario("Joaquín", "Morales", "joaquin.morales@email.com"));
        usuarios.add(new Usuario("Mía", "Carrillo", "mia.carrillo@email.com"));
        usuarios.add(new Usuario("Iván", "Figueroa", "ivan.figueroa@email.com"));
        usuarios.add(new Usuario("Paula", "Campos", "paula.campos@email.com"));


        // File, FileWriter, PrintWriter
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            for (Usuario item : usuarios) {
                printWriter.println(item.formatoExportar());
            }

        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        } finally {
            try {
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void escribirPrimitivos(String path){

        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeUTF("sdfsdfsdfsdfsdf");

        } catch (IOException e) {
            System.out.println("Error en el fichero");

        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void lecturaPrimitivos(String path){
        File file = new File(path);


        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object dato = objectInputStream.readObject();
            System.out.println(dato);
        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la lectura de la clase");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void escribirUsuarios(String path){

        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Usuario("Borja", "Martin","bmartin@gmail.com"));

        } catch (IOException e) {
            System.out.println("Error en el fichero");

        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void lecturaUsusarios(String path){
        File file = new File(path);
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Usuario usuario = (Usuario) objectInputStream.readObject();
            usuario.mostrarDatos();
        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en la lectura de la clase");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }

}
