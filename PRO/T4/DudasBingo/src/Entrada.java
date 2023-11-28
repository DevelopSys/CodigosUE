public class Entrada {


    public static void main(String[] args) {
        // carton -> array
        int[] carton = new int[10]; // 8 5
        int[] numerosBingo = new int[99]; // 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

        // rellenar el carton
        // aleatorio -> Math.random()*99 [0-98]+1 -> 1 al 99
        // generar 10 numeros
        for (int i = 0; i < 10; i++) {
            // ya esta en la lista? -> recorrerla y ver si esta -> true o false
            // es par? -> meter en la lista es impar-> sacar otro numero
            int numero;
            boolean comprobacion = false;
            do {
                numero = (int) (Math.random() * 99) + 1;
                if (numero % 2 != 0) {
                    comprobacion = true;
                } else {
                    comprobacion = false;
                }
                // recorrer la lista -> for -> true/false
            } while (comprobacion);
            carton[i] = numero;
        }

        // comprobar si un numero esta? -> 8

        boolean estaNumero = false;
        for (int i = 0; i < carton.length; i++) {
            if (carton[i] == 26) {
                estaNumero = true;
                break;
            }
        }

        if (estaNumero) {
            System.out.println("El numero ha sido encontrado");
        } else {
            System.out.println("El numero no esta en el carton");
        }


        // solucion decrementar

        for (int i = 0; i < 10; i++) {
            // ya esta en la lista? -> recorrerla y ver si esta -> true o false
            // es par? -> meter en la lista es impar-> sacar otro numero
            int numero = (int) (Math.random() * 99) + 1;
            /*if (numero == posicionAnterior) {
                i--;
            } else {

            }*/
            // recorrer la lista -> for -> true/false

            carton[i] = numero;
        }


    }
}
