import java.util.Scanner;

public class Entrada {

    static Scanner lectorTeclado = new Scanner(System.in);
    // variables
    // metodos
    public static void main(String[] args) {
        // variables
        // ARITMETICOS -> operaciones
        // metodoOperadoresAritmeticos();
        // ASIGNACION -> igualdad
        // metodoOperadoresAsignacion();
        // COMPARACION -> comparar
        // metodoOperadoresComparacion();
        // LOGICOS -> juntar condiciones
        // metodoOperadoresLogicos();
        // cambiosTipo();
        // ejercicioBar();
        ejercicioCadenas();
    }

    private static void ejercicioCadenas() {
        // Hágase una aplicación que lea dos cadenas y las compare del siguiente modo:
        /*
        son iguales ?
        La primera es menor que la segunda
        Son distintas
         */
         // lectorTeclado
        String palabra1, palabra2;
        System.out.println("Indica cual es la primera palabra");
        palabra1 = lectorTeclado.next();
        System.out.println("Indica cual es la segunda palabra");
        palabra2 = lectorTeclado.next();
        boolean iguales = palabra1.equals(palabra2); // son iguales importando mayusculas / minusculas // Hola - hola
        boolean igualesSinCap = palabra1.equalsIgnoreCase(palabra2); // son iguales sin importar mayusculas / minusculas // Hola - hola
        boolean segundaMenor = palabra2.length() < palabra1.length() ; // menos letras
        boolean sonDistintas = !palabra1.equalsIgnoreCase(palabra2); // uno uno -> true -> false
        System.out.println("Son iguales con CAPS "+iguales);
        System.out.println("Son iguales sin CAPS "+igualesSinCap);
        System.out.println("Segunda es menor "+segundaMenor);
        System.out.println("Son distintas "+sonDistintas);
    }

    private static void ejercicioBar() {
        /*
        Unos amigos entra en un bar que ofrece las bebidas a 1,25€ y los bocadillos a 2,05€.
        El camarero les pregunta cuántas bebidas y bocadillos quieren.
        Calcula el coste de la consumición, mostrando primero el coste de las bebidas y de los bocadillos.
         */
        Scanner lectorTeclado = new Scanner(System.in);

        final double COSTE_BEBIDA = 1.25;
        final double COSTE_BOCATA = 2.05;
        System.out.println("Cuantas bebidas quereis");
        int cantidadBebidas = lectorTeclado.nextInt();
        System.out.println("Cuantas bocatas quereis");
        int cantidadBocatas = lectorTeclado.nextInt();

        double costeBocatas = cantidadBocatas * COSTE_BOCATA;
        double costeBebidas = cantidadBebidas * COSTE_BEBIDA;
        double costeTotal = costeBocatas+costeBebidas;

        System.out.println("Los bocatas cuestan "+costeBocatas);
        System.out.println("Las bebidas cuestan "+costeBebidas);
        System.out.println("Todo ha costado "+costeTotal);

    }

    private static void cambiosTipo() {
        int numero = 43;
        // casting
        float cambio = (float) numero; // 43 -> 43.0
        byte cambioPequenio = (byte) numero;
        // parsing
        String cambioPalabra = String.valueOf(numero); // "43"
        String cambioBoolean = "false";
        boolean cambioBool = Boolean.parseBoolean(cambioBoolean); // no
        // "0987654" -> int
        // "349876543" -> int
        // Object() -> Coche
    }

    private static void metodoOperadoresLogicos() {
        // juntan condiciones -> resultado un boolean -> true / false
        // && AND -> y
        // || OR -> o
        /* &&
        C1  C2  R
        T    T  T
        F    T  F
        T    F  F
        F    F  F
         */
        /* ||
        C1  C2  R
        T    T  T
        F    T  T
        T    F  T
        F    F  F
         */
        int numero1 = 3;
        int numero2 = 5;
        int numero3 = 70;

        boolean resultado = numero1 > numero2 || (numero2 < 10 && numero1 > numero3); // F

    }

    private static void metodoOperadoresComparacion() {
        // resultado de una comparacion -> true / false -> boolean
        int numero1 = 45;
        int numero2 = 44;
        boolean resultado;
        // un numero es mas grande que otro n1 > n2
        resultado = numero1 > numero2; // true
        // un numero es mas grande o igual que otro n1 >= n2
        resultado = numero1 >= numero2; // true
        // un numero es mas pequeño que otro n1 < n2
        resultado = numero2 < numero1; // true
        // un numero es mas pequeño o igual que otro n1 <= n2
        resultado = numero2 <= numero1; // true
        // es igual un numero a otro n1 == n2
        resultado = numero1 == numero2; // false -> solo para comparaciones de numeros
        // es diferente un numero a otro n1 != n2
        resultado = numero1 != numero2; // true
    }

    private static void metodoOperadoresAsignacion() {
        // lo mismo que las aritmeticas pero asignan
        int operando1 = 8;
        int operando2 = 9;
        int resultado = 0;
        resultado += operando1; // resultado = resultado + operando1 // 8
        resultado -= operando2; // 8 - 9 -> -1
        resultado *= 3; // -3 (-1 * 3)
        resultado = 6;
        resultado /= 2; // 3 (6/2 -> 3)
        resultado %= 2; // 1 (3%2 -> 1)
    }

    public static void metodoOperadoresAritmeticos() {
        // operaciones monarias
        int operador1 = 7;
        operador1++; // 8
        int operador2 = 3;
        operador2--; // 2
        // operaciones binarias-> suma resta multi divi modulo
        String operacion = "suma";
        // suma
        int suma = operador1 + operador2;
        System.out.println("La suma de los dos numeros es " + suma);
        // String resultadoSuma = operacion+operador1; // concatena
        // System.out.println(resultadoSuma);
        // resta
        int resta = operador1 - operador2;
        System.out.println("La resta de los dos numeros es " + resta);
        // multiplicacion
        int multiplicacion = operador1 * operador2;
        System.out.println("La multiplicacion de los dos numeros es " + multiplicacion);
        // division
        // cambiar el tipo de uno de los operadpores
        float division = operador1 / operador2; // 7/3 -> 2.0 (real) 2 (entera) // la division de dos int es un int
        System.out.println("La division de los dos numeros es " + division);
        // modulo -> resto de la division entre dos numeros
        int modulo = operador1 % operador2; // el modulo me puede valer para -> par (0) / impar (1) // cambios de base
        System.out.println("El resto de la division de los dos numeros es " + modulo);


    }

}
