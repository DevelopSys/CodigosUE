import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el valor del primer numero");
        int operando1 = scanner.nextInt();
        System.out.println("Introduce el valor del segundo numero");
        int operando2 = scanner.nextInt();

        System.out.println("El resultado de la suma es: "+(operando1+operando2));
        System.out.println("El resultado de la resta es: "+(operando1-operando2));
        System.out.println("El resultado de la mmultiplicacion es: "+(operando1*operando2));
        System.out.println("El resultado de la division es: "+(operando1/operando2));
        System.out.println("El resultado de la division real es: "+((double)operando1/operando2));
        System.out.println("El resultado del resto es: "+(operando1%operando2));
    }
}
