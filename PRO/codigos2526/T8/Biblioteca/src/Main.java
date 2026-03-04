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
        // revista.mostraDatos();
        // libro.publicarContenido();
        // libro.mostraDatos();
        ArrayList<Elemento> listaElementos = new ArrayList();
        listaElementos.add(pelicula);
        listaElementos.add(libro);
        listaElementos.add(revista);

        listaElementos.forEach(Elemento::vender);

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
