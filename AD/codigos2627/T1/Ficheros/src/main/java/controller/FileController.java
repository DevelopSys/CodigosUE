package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class FileController {

    private final String basePath = "src/main/java/files/";

    public void getInfoFile(String path) {
        // src/main/java/files/example.txt
        File file = new File(basePath + path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en tarea de IO");
            }
        } else {
            if (file.isDirectory()) {
                File[] ficheros = file.listFiles();
                for (File item : ficheros) {
                    System.out.println(item.getAbsolutePath());
                }
            }
            System.out.println("Existe " + file.exists());
            System.out.println("Se puede escribir " + file.canWrite());
            System.out.println("Se puede leer " + file.canRead());
            System.out.println(file.getAbsolutePath());
        }


    }

    public void writeFileTXT(String path, String mensaje) {
        File file = new File(basePath + path);
        /*FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            // escritura
        } catch (IOException e) {
            System.out.println("Fallo en IO");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Fallo en IO");
            }
        }*/
        /*
        // pongo el fichero en modo escritura caracter a caracter
        try (FileWriter fileWriter = new FileWriter(file)) {
            // fileWriter.write(mensaje);
            fileWriter.write("123\n");
            fileWriter.write(124);
            fileWriter.write(125);
            fileWriter.write(126);
            // implicitamente el fw queda cerrrado
        } catch (IOException e) {
            System.out.println("Error en IO");
        }
        */
        // pones el fichero en modo escritura, pero de forma linea a linea
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
            printWriter.println("Ejemplo de linea1");
            printWriter.println("Ejemplo de linea2");
            printWriter.println("Ejemplo de linea3");
        } catch (IOException e) {
            System.out.println("Error en IO");
        }
    }

    public void readFileTXT(String path) {
        File file = new File(basePath + path);
        // lectura caracter a caracter
        // FileReader fileReader = null;
        /*
        try (FileReader fileReader = new FileReader(file)){
            int code = -1;
            while ((code = fileReader.read())!= -1){
                System.out.print((char) code);
            }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta no existe");
        } catch (IOException e) {
            System.out.println("Error de IO");
        }*/

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error en IO");
        }

    }

    public void exportCSV(String path) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Usuario1", "Apellido1", "mail1@gmail.com"));
        list.add(new User("Usuario2", "Apellido2", "mail2@gmail.com"));
        list.add(new User("Usuario3", "Apellido3", "mail3@gmail.com"));
        list.add(new User("Usuario4", "Apellido4", "mail4@gmail.com"));
        list.add(new User("Usuario5", "Apellido5", "mail5@gmail.com"));
        File file = new File(basePath + path);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            printWriter.println("name,surname,mail");
            for (User item : list) {
                printWriter.println(item.toCSV());
                // printWriter.println(item.getName()+""+"";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<User> importCSV(String path) {
        ArrayList<User> list = new ArrayList<>();
        File file = new File(basePath + path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                System.out.println("Sacando usuarios");
                // System.out.println(linea);  Usuario1,Apellido1,mail1@gmail.com
                String[] data = linea.split(",");
                User user = new User(data[0], data[1], data[2]);
                list.add(user);
                user.showData();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void writeObject(String path) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Usuario1", "Apellido1", "mail1@gmail.com"));
        list.add(new User("Usuario2", "Apellido2", "mail2@gmail.com"));
        list.add(new User("Usuario3", "Apellido3", "mail3@gmail.com"));
        list.add(new User("Usuario4", "Apellido4", "mail4@gmail.com"));
        list.add(new User("Usuario5", "Apellido5", "mail5@gmail.com"));
        File file = new File(basePath + path);
        // File -> FileOutputStream -> ObjectOutoStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readObject(String path){
        File file = new File(basePath+path);
        // File -> FileInputStream -> ObjectInputStream
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
             //User user = (User) ois.readObject();
             // user.showData();
             ArrayList<User> list = (ArrayList<User>) ois.readObject();
            for (User item: list) {
                item.showData();
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
