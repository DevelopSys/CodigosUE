import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {
        GestionFicheros gestionFicheros = new GestionFicheros();
        // gestionFicheros.trabajoFicherosBase();
        //gestionFicheros.flujoEscritura("src/resources/escritura.txt");
        // gestionFicheros.flujoLectura("src/resources/escritura.txt");
        gestionFicheros.flujoEscrituraObjetos("src/resources/escritura.obj");
    }
}
