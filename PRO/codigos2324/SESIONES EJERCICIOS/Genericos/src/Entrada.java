import controller.Coleccion;
import model.*;

public class Entrada {

    public static void main(String[] args) {
        Coleccion<Libro, Double> coleccionLibros = new Coleccion<>();

        Coleccion<Video, Integer> coleccionPeliculas = new Coleccion<>();

        Coleccion<Audio, String> coleccionAudio = new Coleccion<>();

        Coleccion<Elemento, Object> coleccion = new Coleccion<>();

        coleccionLibros.addElementos(new Libro());
        coleccionAudio.addElementos(new Audio());
        coleccionPeliculas.addElementos(new Video());

    }
}
