import controller.OperacionesFicheros;

public class Entrada {

    public static void main(String[] args) {

        OperacionesFicheros operacionesFicheros = new OperacionesFicheros();
        // operacionesFicheros.crearDirectorio();
        // operacionesFicheros.obtenerInformacion("src/resources/ejemplo.tx");
        // operacionesFicheros.listarFicheros("/Users/borja");
        // pedir al usuario que mensaje quiere cifrar
        // quiero pasarte un mensaje y que nadie se entere de esta informacion
        // operacionesFicheros.realizarEscritura("src/resources/procesos/escritura/mensaje.txt");
        //operacionesFicheros.encriptar("src/resources/procesos/fichero/mensaje.txt");
        // operacionesFicheros.desencriptar("src/resources/procesos/fichero/mensaje.txt");
        // operacionesFicheros.descifrar("src/resources/procesos/fichero/codigos.txt");
        // operacionesFicheros.importacionUsuarios("src/resources/procesos/objetos/usuarios.txt");
        // operacionesFicheros.exportarUsuarios("src/resources/procesos/objetos/usuarios.txt");
        // operacionesFicheros.escribirPrimitivos("src/resources/procesos/objetos/primitivos.obj");
        // operacionesFicheros.lecturaPrimitivos("src/resources/procesos/objetos/primitivos.obj");
        // operacionesFicheros.escribirUsuarios("src/resources/procesos/objetos/complejos.obj");
        operacionesFicheros.lecturaUsusarios("src/resources/procesos/objetos/complejos.obj");
    }
}
