import java.util.Scanner;

public class MainDoWhile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Evaluacion de numeros");
        int numero;
        do{
            System.out.println("Introduce un numero");
            numero = scanner.nextInt();
        }while (numero<0 && numero>10);
        // 2098765432 R 0
    }
}
