import model.Elemento;
import model.Libro;
import model.Pelicula;
import model.Soporte;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Elemento elemento = new Elemento("123-123","Borja MArtin",1);
        Pelicula pelicula = new Pelicula("123-123","Director",1,120);
        // pelicula.mostraDatos();
        Libro libro = new Libro("123123","Escritor",1, Soporte.FISICO);
        // libro.publicarContenido();
        // libro.mostraDatos();
        ArrayList<Elemento> listaElementos= new ArrayList();
        listaElementos.add(pelicula);
        listaElementos.add(libro);
    }
}
