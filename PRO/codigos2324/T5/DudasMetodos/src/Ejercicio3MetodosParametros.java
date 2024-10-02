import java.util.Scanner;

public class Ejercicio3MetodosParametros {


    // crea un array y rellenalo con 10 numeros por teclado? y mostrarlo normal inverso normal
    public static void main(String[] args) {
        System.out.println("Ejercicio 3 con métodos");
        Scanner scanner = new Scanner(System.in);
        System.out.println("De cuantos numeros quieres el array");
        int numerosArray= scanner.nextInt();
        int[] numeros = rellenarArray(numerosArray); // int[] numeros
        System.out.println("De cuantos numeros quieres el array");
        numerosArray= scanner.nextInt();
        int[] numeros2 = rellenarArray(numerosArray); // int[] numeros
        // mostrarArray(rellenarArray(5));

        // el array ya esta relleno
        //mostrarArray(numeros);
        //mostrarArray(numeros2);
        System.out.println("Que array quieres mostrar (1-2");
        int opcion = scanner.nextInt();
        System.out.println("En que orden quieres mostrarlo (normal-inverso");
        String orden = scanner.next();
        if (opcion == 1){
            if (orden.equalsIgnoreCase("normal")){
                mostrarArray(numeros);
            } else {
                mostrarInverso(numeros);
            }
        } else {
            if (orden.equalsIgnoreCase("normal")){
                mostrarArray(numeros2);
            } else {
                mostrarInverso(numeros2);
            }
        }
        //mostrarInverso(numeros);
        //mostrarInverso(numeros2);
        //mostrarArray(numeros);
        //mostrarArray(numeros2);
    }

    // rellenar array

    public static int[] rellenarArray(int n){
        int numeros[] = new int[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Indica numero");
            int numero = scanner.nextInt();
            numeros[i] = numero;
        }
        return numeros;
    }
    public static void mostrarArray(int[] array){
        for ( int numero  : array ) {
            System.out.print(numero +" ");
        }
        System.out.println();
    }
    public static void mostrarInverso(int[] array){
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }

    // mostrar array

    // mostrar array inverso

}
