import java.util.Scanner;

public class MainFor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ejecucion de lineas de forma repetitiva");
        // for (inicio, final, incremento){ cuerpo } [0,5] -=2

        int numeroPositivos = 0;
        int numeroNegativos = 0;
        int acumulador = 0;
        double media = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce numeros");
            int numero = scanner.nextInt();
            if (numero < 0) {
                numeroNegativos++;
            } else {
                numeroPositivos++;
            }
            acumulador += numero;
        }

        

        System.out.println("El numero de positivos es "+numeroPositivos);
        System.out.println("El numero de negativos es "+numeroNegativos);
        System.out.println("El sumatorio es "+acumulador);
        media = (float)acumulador/5;
        System.out.println("La media es "+ media);
    }
}
