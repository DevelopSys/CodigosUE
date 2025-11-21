import java.util.Scanner;

public class MainWhile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Evaluando un conjunto de numeros");
        int numero=10;
        System.out.println(Long.MAX_VALUE);
        while (numero%2==0){
            System.out.println("Introduce numero");
            numero = scanner.nextInt();
            if (numero==0){
                break;
            }
            // break
            // cambie la condicion de evaluacion
        }
        System.out.println("Terminando......");
    }
}
