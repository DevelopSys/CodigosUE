package ejercicio4;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int clave = (int) (Math.random()*4001)+1000;
        int intentos = 5;
        int claveUsuario = 0;
        boolean bloqueo = false;
        boolean apertura = false;
        System.out.println(clave);

        do {
            System.out.println("Indica la clave");
            claveUsuario = scanner.nextInt();
            if (claveUsuario == clave){
                apertura =true;
            } else {
                intentos--;

            }
        }while (!apertura && intentos>0);

        if (apertura){
            System.out.printf("Enhorabuena has abierto la caja en %d intentos %n",5-intentos);
        } else {
            System.out.println("Bloqueda");
        }




    }
}
