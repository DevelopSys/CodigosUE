package controller;

import model.Usuario;

import java.io.*;

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
}
