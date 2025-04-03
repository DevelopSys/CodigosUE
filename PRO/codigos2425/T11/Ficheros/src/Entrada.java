import controller.OperacionesFicheros;

public class Entrada {

    public static void main(String[] args) {

        OperacionesFicheros operacionesFicheros = new OperacionesFicheros();
        // operacionesFicheros.crearDirectorio();
        // operacionesFicheros.obtenerInformacion("src/resources/ejemplo.tx");
        // operacionesFicheros.listarFicheros("/Users/borja");
        // pedir al usuario que mensaje quiere cifrar
        // quiero pasarte un mensaje y que nadie se entere de esta informacion
        operacionesFicheros.realizarEscritura("src/resources/procesos/escritura/mensaje.txt");
    }
}
