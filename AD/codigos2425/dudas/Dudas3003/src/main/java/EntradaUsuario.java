import model.Usuario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EntradaUsuario {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Carlos", "González", 123456789, 30));
        usuarios.add(new Usuario("María", "López", 987654321, 25));
        usuarios.add(new Usuario("Juan", "Martínez", 654987321, 28));
        usuarios.add(new Usuario("Ana", "Rodríguez", 321654987, 22));
        usuarios.add(new Usuario("Pedro", "Fernández", 159753468, 35));
        usuarios.add(new Usuario("Laura", "Díaz", 753951852, 27));
        usuarios.add(new Usuario("Luis", "Pérez", 852369741, 40));
        usuarios.add(new Usuario("Sofía", "Gómez", 456123789, 32));
        usuarios.add(new Usuario("Andrés", "Ramírez", 789456123, 29));
        usuarios.add(new Usuario("Elena", "Torres", 369258147, 26));

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("ejercicio3.obj")));
            objectOutputStream.writeObject(usuarios);
            objectOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
