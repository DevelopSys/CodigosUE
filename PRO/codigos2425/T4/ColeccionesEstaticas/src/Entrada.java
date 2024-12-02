public class Entrada {

    public static void main(String[] args) {
        int numero = 5;
        String palabra = "asd";

        int[] numerosDatos = new int[]{1,5,8};
        // obtener cuantos elementos tiene
        int tamanio = numerosDatos.length;
        System.out.println("La longitud del array es "+tamanio);
        // obtener el valor de una posicion
        int valor = numerosDatos[numerosDatos.length-1];
        System.out.println("El valor en la posicion 0 es "+valor);
        // evaluar si el valor de una posicion es = a algo
        if (numerosDatos[0]==1){
            System.out.println("Posicion coincide");
        } else {
            System.out.println("No coincide");
        }
        // asignar un valor en una posicion 40 20 90
        numerosDatos[1] = 20;
        numerosDatos[0] = 40;
        numerosDatos[2] = 90;
        valor = numerosDatos[2];
        System.out.println("El valor en la posicion 0 es "+valor);
        // sacar todos los elementos del array -> foreach
        for (int i = 0; i < numerosDatos.length; i++) {
            System.out.println(numerosDatos[i]);
        }

        // asignar de forma recurrente valores a un array
        int[] numeros = new int[20];
        // 0 0 0 0 0 0 0 0 0 0
        // 0 - 0.99
        System.out.println("Rellenando array");
        for (int i = 0; i < numeros.length; i++) {
            int aleatorio;
            do{
                 aleatorio= (int) (Math.random()*20)+1;
            }while (estaNumero(aleatorio,numeros));

            numeros[i] = aleatorio;
        }
        System.out.println("Mostrando el contenido del array");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // generar aleatorio en el bingo
            // comprobar si esta en el carto
                // recorro fila 1, si esta el numero fila1++
                // recorro fila 2, si esta el numero fila2++
                // recorro fila 3, si esta el numero fila3++
                    // numero ++ aciertos
        // repetir hasta que la cuenta de aciertos del carton sea 10
        // aciertosL1
        // aciertosL2
        // aciertosL3

        int[][] carton = new int[3][5];
        /*
         0 0 0 0 0
         0 0 0 0 0
         0 0 0 0 0
         */
        //carton[2];
        int[][] cartonDatos = { {1,2,3},{4,5,6},{7,8,9}};
        /*
         1 2 3
         4 5 6
         7 8 9
         */



    }
    public static boolean estaNumero(int numeroEvaluar, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==numeroEvaluar){
                return true;
            }
        }
        return false;
    }
}
