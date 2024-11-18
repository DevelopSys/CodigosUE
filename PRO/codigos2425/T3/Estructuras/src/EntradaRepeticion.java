import java.util.Scanner;

public class EntradaRepeticion {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // estructuraFOR();
        // estructuraWHILE();
        // estructuraDOWHILE();
        ejecucionMenu();

    }

    private static void ejecucionMenu() {
        /*
        1- ingresar
        2- sacar
        3- consultar
        4- salir
        que quieres hacer
         */
        int opcion =0;
        do{
            System.out.println("1. Ingregar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar");
            System.out.println("4. Salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Te dispones a ingresar dinero");
                    break;
                case 2:
                    System.out.println("Te dispones a sacar dinero");
                    break;
                case 3:
                    System.out.println("Te dispones a consultar");
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion incorrecta, intentalo de nuevo");
            }
        }while (opcion!=4);
    }

    private static void estructuraDOWHILE() {
        // primero ejecuta algo
        // pregunta si la condicion de repeticion se cumple
        int nota;
        do {
            System.out.println("Introduce una nota");
            nota=scanner.nextInt();
        }while (nota<0 || nota>10);
    }

    private static void estructuraWHILE() {
        // repite mieentras se cumpla la condicion
        System.out.println("Dime una nota");
        int nota = scanner.nextInt();

        while (nota<0 || nota>10){
            System.out.println("Dime una nota");
            nota = scanner.nextInt();
        }
        System.out.println(nota);
        /*while (nota>0){
            System.out.println("Ejecutando");
            System.out.println("La nota es "+nota);
            nota--;
            // para que no sea bucle infinito: que la condicion se modifique
        }*/

    }

    public static void estructuraFOR() {
        // [i=0, i=4] // 0,1,2,3,4,5XXXXXX
        // introduce 10 numeros por teclado y saca el sumatorio de todos ellos
        // saca la media de los numeros introducidos
        // cuantos de los numeros introducidos son pares
        /*int numeroPares=0;
        int sumatorio = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce numero");
            int numero = scanner.nextInt();
            sumatorio += numero;
            if (numero % 2 == 0) {
                numeroPares++;
            }
        }

        System.out.println("La suma de todos los numeros es: " + sumatorio);
        System.out.println("El numero medio es: " + (double) sumatorio / 10);
        System.out.println("El numero de pares es: "+numeroPares);*/

        // tabla de multiplicar del 8
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11 ; j++) {
                System.out.printf("%d * %d = %d\n",j,i,j*i);
            }
        }

        System.out.println("Introduce el numero con el que juegas");
        int numero =scanner.nextInt();
        for (int i = 0; i < 5; i++) {
            // 0 - 0,99 -> 0*5 = 0 0,99*5= 4
            int aleatorio = (int)(Math.random() *801);
            System.out.println(aleatorio);
            if (numero == aleatorio){
                System.out.println("Numero adivinado");
            }
        }

    }
}
