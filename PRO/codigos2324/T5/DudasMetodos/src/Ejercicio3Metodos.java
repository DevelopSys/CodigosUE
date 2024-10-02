import java.util.Scanner;

public class Ejercicio3Metodos {

    static int[] numeros = new int[10];
    // crea un array y rellenalo con 10 numeros por teclado? y mostrarlo normal inverso normal
    public static void main(String[] args) {
        System.out.println("Ejercicio 3 con métodos");
        rellenarArray();
        // el array ya esta relleno
        mostrarArray();
        mostrarInverso();
        mostrarArray();
    }

    // rellenar array

    public static void rellenarArray(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Indica numero");
            int numero = scanner.nextInt();
            numeros[i] = numero;
        }
    }
    public static void mostrarArray(){
        for ( int numero  : numeros ) {
            System.out.print(numero +" ");
        }
        System.out.println();
    }
    public static void mostrarInverso(){
        for (int i = numeros.length-1; i >= 0; i--) {
            System.out.print(numeros[i] +" ");
        }
        System.out.println();
    }

    // mostrar array

    // mostrar array inverso

}
