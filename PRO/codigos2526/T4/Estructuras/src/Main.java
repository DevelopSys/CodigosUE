import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 8;
        String nombre = "Borja";
        numero = 10;
        nombre = "Maria";
        // un conjunto de numeros
        // indica cuantos huecos quieres reservar
        System.out.println("Dime cuantos alumnos tienes");
        int nAlumnos = scanner.nextInt();
        int[] notas = new int[nAlumnos];
        // [0,0,0,0,0,0,0,0]
        boolean[] aciertos = new boolean[4];
        // [false,false,false,false]
        String[] palabras = new String[5];
        // [null,null,null,null,null]
        int[] numerosRellenos = {4, 5, 6, 7};
        // [4,5,6,7]
        /*
        String[] palabrasRellenas = {"palabra1","palabra2","palabra3","palabra4"};
        //      0          1          2           3
        // cuantos elementos tiene el array -> tamaño
        System.out.println("El tamaño del array es de "+palabrasRellenas.length);
        // saber un elemento concreto
        System.out.println("El elemento de la posicion 2 es "+palabrasRellenas[palabrasRellenas.length-1]);
        // System.out.println("Procedemos a sacar todas las palabras");
        //
        // ["palabra1","palabra2","palabra3","palabra4"]
        //   0,1,2,3
        /*
        // recorrer elementos - para alterar sus valores
        for (int i = 0; i < palabrasRellenas.length; i++) {
            System.out.println(palabrasRellenas[i]);
        }
        // vale para poder recorrer de forma COMPLETA una coleccion
        for( String item : palabrasRellenas ){
            System.out.println("El dato asociado a la posicion iterada es "+item);
        }
        palabrasRellenas[0]="nueva palabra";
        palabrasRellenas[1]="otra palabra";
        palabrasRellenas[2]="palabra";
        palabrasRellenas[3]="cosa diferente";
        for( String item : palabrasRellenas ){
            System.out.println("El dato asociado a la posicion iterada es "+item);
        }
        */
        System.out.println("Vamos a ver las notas de los alumnos");
        for (int item : notas) {
            System.out.println(item);
        }
        System.out.println("Perfecto, ahora vamos a rellenar las notas");
        /*
        for (int i = 0; i < notas.length; i++) {
                System.out.println("Por favor introduce la nota del alumno");
            int nota;
            do {
                nota = scanner.nextInt();
                if (nota<0 || nota>10){
                    System.out.println("Error en la nota, por favor metela de nuevo");
                }
            }while (nota<0 || nota>10);

            notas[i] = nota;
        }*/
        for (int i = 0; i < notas.length; i++) {
            notas[i] = (int)(Math.random() *51); // 0 - 0.9999999 0 - 10
        }
        System.out.println("Vamos a ver el resumen de notas");
        // cuantos suspenso, cuantos ap, cuantos MH, la nota media
        // [10,4,5,7,8,5,4,2]
        int numeroAp = 0, numeroSS = 0, numeroMH = 0;
        double acumulador = 0;
        System.out.println("Vamos a ver las notas despues de meterlas");
        for (int item : notas) {
            System.out.println(item);
        }
        System.out.println("Realizando calculos......");
        for (int nota : notas) {
            acumulador += nota;
            if (nota < 5) {
                // ss
                numeroSS++;
            } else {
                // ap
                numeroAp++;
                if (nota == 10) {
                    // mh
                    numeroMH++;
                }
            }

        }
        System.out.println("El resumen es:");
        System.out.println("El numero de ap es: " + numeroAp);
        System.out.println("El numero de ss es: " + numeroSS);
        System.out.println("El numero de mh es: " + numeroMH);
        System.out.println("La nota media obtenida es: " + (acumulador / notas.length));
    }
}
