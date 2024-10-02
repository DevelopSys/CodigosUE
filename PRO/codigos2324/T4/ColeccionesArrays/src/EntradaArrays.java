import java.util.Scanner;

public class EntradaArrays {

    public static void main(String[] args) {
        int[] numeros = new int[10];

        // que no sea igual a lo que ya ha salido
        // necesito un array con los numeros que ya han salido
        // new int[99] // 0s
        int[] numerosSalidos = new int[99];
        int[] carton = new int[10];

        for (int i = 0; i < 10; i++) {
            do{
                int aleatorio = (int) (Math.random()*99)+1;
                // si el aleatorio está en el conjunto de salidos, repite
                // recorro el array de carton y si esta false
            } while ();
            // garantizo que no está
            // añade al carton
            numeros[i]= aleatorio;
        }
        System.out.println("Indica que numero quieres saber si esta");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 123,1,23,123,21,3,4356,75,64,3,425
        for ( int item : numeros ) {
            if (item == num){
                System.out.println("El numero esta");
            }
        }
    }
}
