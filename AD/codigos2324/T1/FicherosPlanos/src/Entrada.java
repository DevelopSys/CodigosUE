import controller.OperacionesFicheros;

import java.io.File;
import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {

        OperacionesFicheros operacionesFicheros= new OperacionesFicheros();
        //operacionesFicheros.lecturaDirectorios(new File("/Users/borjam/Documents/GitHub/CodigosUE/AD"));
        //operacionesFicheros.lecturaDirectorios(new File("/Users/borjam/Documents/GitHub/CodigosUE/PMDM"));
        //operacionesFicheros.escribirFichero();
        //operacionesFicheros.escribirFicheroBuffered();
        //operacionesFicheros.lecturaPlana();
        operacionesFicheros.lecturaBuffered();

    }

}
