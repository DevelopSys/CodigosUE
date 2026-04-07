import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Elemento elemento = new Elemento("123-123","Borja MArtin",1);
        Pelicula pelicula = new Pelicula("123-123", "Director", 1, 130);

        // pelicula.mostraDatos();
        Libro libro = new Libro("123123", "Escritor", 1, Soporte.DIGITAL);

        Revista revista = new Revista("234234", "CuartoMilenio", 2, Tapa.Blanda, Tirada.Internacional);
        Libro libro2 = new Libro("345345", "Dan Brown", 3, Soporte.FISICO);


        // revista.mostraDatos();
        // libro.publicarContenido();
        // libro.mostraDatos();
        ArrayList<Elemento> listaElementos = new ArrayList();
        listaElementos.add(pelicula);
        listaElementos.add(libro);
        listaElementos.add(revista);
        listaElementos.add(libro2);

        for (Elemento elemento : listaElementos) {
            // elemento.vender();
            elemento.mostraDatos();
            if (elemento instanceof Libro) {
                ((Libro) elemento).publicarContenido();
            }
            // quiero que se pueda ejecutar el metodo alquilar -> alquilable
            if (elemento instanceof Alquilable) {
                ((Alquilable) elemento).alquilar();
            }
        }

        // listaElementos.forEach(Elemento::vender);

        // listaElementos.forEach(Elemento::mostraDatos);

        /*for (Elemento item  : listaElementos  ) {
                item.mostraDatos();
        }*/
        // listaElementos.forEach(data -> data.mostraDatos());

        /*for (Elemento elemento : listaElementos) {
            if (elemento.getCodigo() == 1) {
                asdasdasd;
                break;
            }
        }*/
        // listaElementos.stream().filter(item->item.getCodigo()==1).forEach();

    }
}
