import controller.Coleccion;
import model.Libro;
import model.Video;

public class Entrada {

    public static void main(String[] args) {


        Libro libro = new Libro(1, "Titulo", "Autor", "papel", 100, 123123, 120);
        //libro.mostrarDatos();

        Video video = new Video(2, "TituloVidio", "Director", "digital", 1000,
                "Director", new String[]{"actor1", "actor2", "actor3"});
        //video.mostrarDatos();

        Coleccion coleccion = new Coleccion();
        coleccion.agregarElementos(video);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);
        coleccion.agregarElementos(libro);

        //coleccion.mostrarElementos();
        coleccion.validadElementos();



    }
}
