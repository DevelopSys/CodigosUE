import java.util.Scanner;

public class OperacionesRecursivas {
    private Scanner scanner = new Scanner(System.in);

    public void calculoFactorial() {
        System.out.println("Que numero quieres calcular");
        int numero = scanner.nextInt(); // 5
        int factorial = factorial(numero);
        // for -> malo
        /*int factorial = numero * (numero-1); // 5*4 = 20
        for (int i = numero-2; i >=1 ; i--) { // i=3,2,1
            factorial = factorial *i;
        }
        factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial = factorial*i;
        }*/
        System.out.printf("El factorial de %d es %d", numero, factorial);
    }

    public void calcularPotencia() {
        System.out.println("Indica la base a calcular");
        int base = scanner.nextInt();
        System.out.println("Indica la potencia a calcular");
        int exponente = scanner.nextInt();

        // int resultado = 0;
        // calcular la recursividad de la potencia indicada
        int resultado = potencia(base,exponente);
        System.out.printf("La potencia de %d elevado a %d es %d", base, exponente, resultado);
    }

    public void calcularFibonacci(){
        System.out.println("Cuantos numeros de fibonacci quieres calcular");
        int numeros = 20;
    }

    // 5 -> 5* 4!
    // 4 -> 4* 3!
    // 3 -> 3* 2!
    // 2 -> 2* 1!
    // 1 -> 1

    // 0 -> 1
    private int factorial(int numero) {
        // realizo el calculo del factorial
        if (numero == 1 || numero == 0) {
            return 1;
        } else {
            System.out.println();
            int facto = numero * factorial(numero - 1);
            return facto;
        }
    }

    private int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            // int potencia = ;
            return base * potencia(base,exponente-1);
        }
    }

    // 2^4 ->
        // R = 2*8
        // 2^3 ->
            // R = 2*4
            // 2^2 ->
            // R = 2*2
                // 2^1 ->
                    // R = 2*1
                    // 2^0 ->
                    // R = 1





}
