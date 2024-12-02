import java.util.Arrays;

public class Entrada {

    public static void main(String[] args) {
        // rellenar un array de 10 posiciones con numeros aleatorios
        // Math.random()*21; 0 - 20
        System.out.println("Generando numeros");
        int[] numerosGenerados = new int[10];
        for (int i = 0; i < numerosGenerados.length; i++) {
            numerosGenerados[i] = (int) (Math.random() * 21);
        }
        Arrays.sort(numerosGenerados);
        System.out.println("Imprimiendo numeros en posiciones originales");
        // sacar todos los numeros generados por consola
        // fori -> cuando la i (indice es muy relevante para el resultado) o tambien si quiero utilizar el for para
        // modificar el array
        /*for (int i = 0; i < numerosGenerados.length; i++) {
            if (i % 2 == 0) {
                System.out.printf("El numero en la posicion %d es %d\n", i, numerosGenerados[i]);
            }
        }*/
        // 34 2 4323 4 3465 6574 3 244 65 764 3
        // foreach -> cuando solo quiero recorrer el array y obtener sus elementos -> recorrido completo
        for (int item : numerosGenerados) {
            System.out.print(item + " ");
        }
        System.out.println();


        /*
        Rotacion a izquierdas
        int auxiliar = numerosGenerados[0];
        for (int i = 0; i < numerosGenerados.length-1; i++) {
            numerosGenerados[i] = numerosGenerados[i+1];
        }
        numerosGenerados[numerosGenerados.length-1] = auxiliar;*/
        /*Rotando a la derecha
        int aux = numerosGenerados[numerosGenerados.length-1];
        for (int i = numerosGenerados.length-1; i>0; i--) {
            numerosGenerados[i] = numerosGenerados[i-1];
        }
        numerosGenerados[0] = aux;*/
        /*
        Rotando por pares
        for (int i = 0; i < numerosGenerados.length; i+=2) {
            int aux = numerosGenerados[i];
            numerosGenerados[i] = numerosGenerados[i+1];
            numerosGenerados[i+1]= aux;
        }*/
        /*
        Invertir array
         */

        // [0 - 2]
        // 0 -> posicion 0 con el de la posicion length-1 -i
        // 1 -> posicion 1 con el de la posicion length-1 -i
        // 2 -> posicion 2 con el de la posicion length-1 -i
        // 8 7 6 5 4 2 -> 5/2 -> 2
        // i = 1
        // aux = 5
        // numeros[1] = 7
        // numeros[3] = 5
        for (int i = 0; i < numerosGenerados.length / 2; i++) {
            int aux = numerosGenerados[i];
            numerosGenerados[i] = numerosGenerados[numerosGenerados.length-1-i];
            numerosGenerados[numerosGenerados.length-1-i] = aux;
        }


        System.out.println("Rotando");
        for (int item : numerosGenerados) {
            System.out.print(item + " ");
        }

        // 34 123 5346 567 86798 2342 123123123123
        // 123 5346 567 86798 2342 123123123123 34


    }
}
