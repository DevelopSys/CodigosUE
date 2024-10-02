package ejercicio3;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la palabra para analizar");
        String palabra = scanner.next();

        //EDU

        if (palabra.length() < 4) {
            palabra = palabra.toUpperCase();
        } else if (palabra.length() < 8) {
            palabra = palabra.toLowerCase();
        } else if (palabra.length() < 11) {
            palabra = palabra.replaceAll("a", "á").replaceAll("e", "é")
                    .replaceAll("i", "í").replaceAll("u", "ú")
                    .replaceAll("o","ó");
        } else {
            String palabraTranform= "";
            // 01234
            // Borja -> letradelaposicion(4)
            // 4 3 2 1 0
            // "ajroB"
            /*StringBuilder builder = new StringBuilder("asdasd");
            builder.append('a');
            builder.reverse();*/

            for (int i = palabra.length()-1; i >= 0 ; i--) {
                palabraTranform += palabra.charAt(i);
            }
            System.out.println("La palabra dada la vuelta es "+palabraTranform + " sobre la original "+palabra);
        }

        /*
         * a.	Si su longitud es menor de 4, transformar todas sus letras en mayúsculas
         * b.	Si su longitud es mayor igual que 4 pero menor que 8, transformar sus letras en minúsculas
         * c.	Si su longitud es mayor igual que 8 pero menor que 11, todas las vocales deberán estar acentuadas
         * d.	Si la longitud es mayor igual a 11 se deberá dar la vuelta a la palabra

         * */
    }

}
