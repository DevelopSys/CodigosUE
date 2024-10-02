import java.util.Scanner;

public class EstructuraFor {

    public static void main(String[] args) {
        // repeticion -> repetir un numero determinado de veces
        // inicial, final, incremento
        // i=0; i<=10; i++ [0,10)
        // i=10; i>0; i-- [10,0)

        int[] numeros = new int[]{3,6,1,23,23,231}; // numeros[0] numeros[4]
        /*for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }*/

        for ( int item: numeros ) {
            System.out.println(item);
            if(item==1){
                break; // terminan las repetieciones
            }
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos numeros quieres introducir");
        int numeroNumeros = scanner.nextInt();
        int numeroPares=0, numeroImpares=0;
        for (int i = 0; i <numeroNumeros ; i++) {
            System.out.println("Introduce el numero");
            int numero = scanner.nextInt();
            if (numero%2==0){
                numeroPares++;
            } else {
                numeroImpares++;
            }
        }
        System.out.println("El numero de pares introducido es: "+numeroPares);
        System.out.println("El numero de impares introducido es: "+numeroImpares);
    }
}
