package ejercicio2;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numerosUsuario = new int[5];
        for (int i = 0; i < numerosUsuario.length; i++) {
            int numero;
            do {
                System.out.println("Introduce el numero "+(i+1));
                numero = scanner.nextInt();
                if (numero<1 || numero>10){
                    System.out.println("numero incorrecto");
                }
            } while (numero<1 || numero>10);
            numerosUsuario[i] = numero;
        }
        int[] numerosAletorios = {-1,-1,-1,-1,-1}; // new int[5]; // 0,0,0,0,0
        for (int i = 0; i < numerosAletorios.length; i++) {
            int numero;
            do {
                System.out.println("Generando numero"+(i+1));
                numero = (int) (Math.random()*10)+1;
                if (estaNumero(numerosAletorios, numero)){
                    System.out.println("numero repetido");
                }
            } while (estaNumero(numerosAletorios, numero));
            numerosUsuario[i] = numero;
        }
        int aciertos = 0;
        // [1,3,5,7,9]
        // [6,2,1,3,8]
        for ( int itemUsuario : numerosUsuario ) {
            // para cada numero del usuario
            for (int itemAleatorio: numerosAletorios ) {
                if (itemUsuario == itemAleatorio){
                    aciertos++;
                    break;
                }
            }
        }
        System.out.println("El numero de aciertos total es de "+numerosAletorios);
    }

    public static boolean estaNumero(int[] listado, int numero){
        for ( int item : listado ) {
            if (item == numero){
                return true;
            }
        }
        return false;
    }
}
