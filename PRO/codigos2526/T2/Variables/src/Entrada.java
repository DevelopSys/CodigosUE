public class Entrada {

    // metodos
    public static void main(String[] args) {
        System.out.println("Programa de variables");
        final String DNI = "12345A";
        String nombre = "Borja"; // va entre comillas dobles
        char letra = 'A';
        int edad = 19; // numeros sin decimales
        float altura = 1.75f;
        double peso = 67.9876;
        edad = edad + 20;
        boolean acierto = false; // true o false

        // aritmeticos: unarios - binarios
        int operandoUno = 10;
        operandoUno++; // incrementara en uno su valor
        operandoUno++; // incrementara en uno su valor
        operandoUno++; // incrementara en uno su valor
        operandoUno++; // incrementara en uno su valor
        operandoUno--; // decrementar en uno su valor
        operandoUno--;
        operandoUno--; // 11
        operandoUno = 5;
        int operandoDos = 2;
        /*
        int suma = operandoUno+operandoDos;
        int resta = operandoUno-operandoDos;
        int multiplicacion = operandoUno*operandoDos;
        float division = (float) operandoUno/operandoDos;
         */
        // int modulo = operandoUno%operandoDos;
        // System.out.println("La suma de los dos operadores es "+(operandoUno+operandoDos));
        // System.out.println("El modulo de los dos operadores es "+modulo); // -> 98765 -> h m s
        operandoUno = 10;
        // operandoUno = operandoUno +5; //  15
        operandoUno += 5; // 15
        operandoUno += 20; // 35
        operandoUno -= 10; // 25
        operandoUno *= 2; // 50
        operandoUno /= 2; // 25
        operandoUno %= 2; // 1
        System.out.println(operandoUno);

        operandoUno = 10;
        operandoDos = 10;
        boolean resultado = operandoUno > operandoDos; // false
        resultado = operandoUno >= operandoDos; // false
        resultado = operandoUno < operandoDos; // true
        resultado = operandoUno <= operandoDos; // true
        resultado = operandoUno == operandoDos; // false
        resultado = operandoUno != operandoDos; // true
        System.out.println("El resultado de la ultima comparacion es " + resultado);

        operandoUno = 10;
        operandoDos = 30;
        int operandoTres = 2;

        resultado = operandoUno==0 && operandoDos!=operandoTres && operandoDos<100;
                    // F && T && T -> F
        System.out.println("El resultado de la primera comparacion logica es "+resultado);

        resultado = operandoUno!=10 || operandoDos > operandoTres*2 || operandoTres>operandoUno || operandoUno > 3*30;
                    // F || T || F || F -> T

        resultado = !true && (operandoDos >= 10 || operandoTres!= 7);
                //  F && (T || T)
                // F && T -> F

        System.out.println(resultado);


    }

    public static void metodoUno() {
        System.out.println("Llamada del metodo 1");
    }
}
