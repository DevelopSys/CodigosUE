import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        System.out.println("Esto es la ejecucion del metodo main del programa");
        for (int i = 0; i < 10; i++) {
            System.out.println("Ejecucion " + i);
        }

        if (new Entrada().realizarOperacion()) {

            System.out.println("Vamos a sumar el resultado de la multiplicacion con 10 " + (multiplicar(5, 5) + 10)); // 25
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce");
            int numero1 = scanner.nextInt();
            System.out.println("Vamos a sumar el resultado de la multiplicacion con 10 " + (multiplicar(numero1, 5) + 10)); // 25
        } else {
            System.out.println("no se hace la operacion");
        }

        sumar(multiplicar(10,2),multiplicar(20,4));
        //sumar(20,80));


    }

    public static Object[] sumar(int operador1, int operador2) {
        System.out.println("Vamos a proceder a realizar una operacion aritmetica");
        System.out.println("El resultado de la suma es " + (operador1 + operador2));
        Object[] cosas= new Object[]{1,false,"asdasd",3.0};
        if (cosas[2].toString().equalsIgnoreCase("asd")){

        }
        return new Object[]{1,1,1,1};
    }


    public boolean realizarOperacion() {
        int numero = (int) (Math.random() * 2);
        if (numero == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int multiplicar(int operador1, int operador2) {

        System.out.println("Vamos a proceder a realizar una operacion aritmetica");
        System.out.println("El resultado de la multiplicacion es " + (operador1 * operador2));
        return operador1 * operador2;
    }
}
