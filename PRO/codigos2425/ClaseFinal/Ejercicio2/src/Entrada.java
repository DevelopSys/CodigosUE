import utils.DivisionByZeroException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        int operador1;
        int operador2;
        Scanner scanner = new Scanner(System.in);
        System.out.println(5/0);

        try {
            System.out.println("Introduce el primer dato");
            operador1 = scanner.nextInt();
            System.out.println("Introduce el segundo dato");
            operador2 = scanner.nextInt();

            double division = (double) operador1 / operador2;
            if (operador2 == 0) {

                throw new DivisionByZeroException("Este es el mensaje personalizado");
            }

            System.out.println("El resultado de la operacion es " + division);
        } catch (InputMismatchException e) {
            System.out.println("Error a la hora de introducir algun dato");
        } catch (ArithmeticException e) {
            System.out.println(e.getCause());
        } catch (DivisionByZeroException e){

            System.out.println(e.getMessage());
        } finally {
            // EJECUTADO SIEMPRE
            System.out.println("Fin del programa");
        }


    }
}
