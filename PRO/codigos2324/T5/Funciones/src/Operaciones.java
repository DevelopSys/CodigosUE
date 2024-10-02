import java.io.File;

public class Operaciones {

    public int sumar(int a, int b){
        return a+b;
    }
    public int multiplicar(int a, int b){
        return a*b;
    }

    public double dividir(int a, int b){
        return (double) a/b;
    }

    public int generarAleatorio(int i){
        return (int) (Math.random()*(i+1));
    }

    // recursividad -> algo que se llama a si mismo
    // calculo de un factorial
    // 5! = 5 * 4 * 3 * 2 * 1

    // liste todos los directorios (y su contenido del s.o.)

    public void listar(File directorio){
        //foreach
            //if (lo que estas viendo es un directorio?)
                //listar(lo que estas viendo);
            //else
                // saca su nombre
    }

    public int calcularFactorial(int numero){
        // 1->1
        if (numero ==1){
            return 1;
        }
        return numero * calcularFactorial(numero-1);
        // 4*3*2*1
        // 4*3 = 12
        // 12*2 = 24
        // 24*1 = 24
        // 4 * (3* (2* (1*1)))
    }

}
