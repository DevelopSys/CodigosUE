package controller;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class OperacionesFicheros {
    public void lecturaFicheros(String path) {
        File file = new File(path);
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int numero;
            while ((numero = fileReader.read()) != -1) {
                System.out.print((char) (numero / 9));
            }
        } catch (IOException e) {
            System.out.println("No puedes hacer la lectura");
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }


        //  hola que tal
    }

    public void lecturaFicherosBuffer(String path) {
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("No puedes hacer la lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }


        //  hola que tal
    }

    public void escrituraSimple(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("La creacion no se puede dar");
            }
        }
        FileWriter fileWriter = null;
        String mensaje = "El enunciado del examen es este: la primera pregunta es XXXXX";

        try {
            fileWriter = new FileWriter(file, true);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                fileWriter.write((int) letra * 9);
            }
        } catch (IOException e) {
            System.out.println("No puedes escribir");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }

    public void escrituraCompleja(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en el IO");
            }
        }
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("Esta es la primera linea");
            printWriter.println("Esta es la segunda linea linea");
        } catch (IOException e) {
            System.out.println("No hay permisos de IO");
        } finally {
            try {
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void escrituraObjetos(String path){
        Usuario usuario = new Usuario(1,"Borja","Martin","correo","123A",123);
        File file = new File(path);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No tienes permisos de creacion");
            }
        }

        ObjectOutputStream dos = null;

        try {
            dos = new ObjectOutputStream(new FileOutputStream(file));
            dos.writeObject(usuario);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero indicado incorrecto");
        } catch (IOException e) {
            System.out.println("No puedes escribir");
        } finally {
            try {
                dos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("El fichero no se puede cerrar");
            }
        }

    }

    public void escrituraObjetosMultiple(String path){
        Usuario usuario1 = new Usuario(1,"Borja1","Martin","correo","123A",123);
        Usuario usuario2 = new Usuario(2,"Borja2","Martin","correo","123A",123);
        Usuario usuario3 = new Usuario(3,"Borja3","Martin","correo","123A",123);
        Usuario usuario4 = new Usuario(4,"Borja4","Martin","correo","123A",123);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        listaUsuarios.add(usuario4);
        File file = new File(path);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No tienes permisos de creacion");
            }
        }

        ObjectOutputStream dos = null;

        try {
            dos = new ObjectOutputStream(new FileOutputStream(file));
            dos.writeObject(listaUsuarios);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero indicado incorrecto");
        } catch (IOException e) {
            System.out.println("No puedes escribir");
        } finally {
            try {
                dos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("El fichero no se puede cerrar");
            }
        }

    }

    public  void lecturaObjeto(){
        // file -> ObjectInputStream -> read (Usuario)
        File file = new File("src/main/java/ficheros/escrituraObjetos.obj");


        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Usuario usuario = (Usuario) ois.readObject();
            System.out.println(usuario.getCorreo());
        } catch (IOException e) {
            System.out.println("Error lectura / escritura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado del objeto");
            }
        }

    }

    public  void lecturaObjetoMultiple(){
        // file -> ObjectInputStream -> read (Usuario)
        File file = new File("src/main/java/ficheros/escrituraObjetos.obj");


        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Usuario> lista = (ArrayList<Usuario>) ois.readObject();

            for (Usuario item: lista) {
                System.out.println(item);
            }

        } catch (IOException e) {
            System.out.println("Error lectura / escritura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado del objeto");
            }
        }

    }

    public void lecturaObjeto2(String path){
        File file = new File(path);
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Usuario usuario = (Usuario) ois.readObject();
            System.out.println(usuario);
        } catch (IOException e) {
            System.out.println("Error en la IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Error a la hora de encontrar la clase");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado del flujo");
            }
        }

    }
}


