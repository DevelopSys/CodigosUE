import controller.OperacionesFicheros;

public class Main {

    public static void main(String[] args) {
        OperacionesFicheros operaciones = new OperacionesFicheros();
        // operaciones.lecturaFicheros("src/main/java/ficheros/escritura.txt");
        // operaciones.lecturaFicherosBuffer("src/main/java/ficheros/ejemplo.txt");
        // operaciones.escrituraSimple("src/main/java/ficheros/escritura.txt");
        //operaciones.escrituraCompleja("src/main/java/ficheros/escrituraBuffer.txt");
        operaciones.escrituraObjetos("src/main/java/ficheros/escrituraObjetos.obj");
    }
}
