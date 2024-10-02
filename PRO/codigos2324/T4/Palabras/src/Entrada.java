import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {


        int lado1 = 3;

        int[][] cuadrado = new int[lado1][lado1];
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                boolean igual;
                int aleatorio;
                do{
                    aleatorio = (int) (Math.random()*(lado1*lado1));
                    igual = false;
                    for (int k = 0; k < cuadrado.length; k++) {
                        for (int l = 0; l < cuadrado[k].length; l++) {
                            if (aleatorio == cuadrado[k][l]){
                                igual = true;
                                break;
                            }
                        }
                        if (igual){
                            break;
                        }
                    }
                } while (igual);
                cuadrado[i][j] = aleatorio;
            }
        }

        for ( int[] fila: cuadrado ) {
            for (int item: fila) {
                System.out.print(item+" ");
            }
            System.out.println();
        }


        String palabra ="Esto es un ejemplo de frase para analizar";
        // cuantas caracteres tengo
        palabra.length();
        // posicion de la primera e
        palabra.indexOf('e');
        // cambia todos los caracteres por otro
        palabra.replaceAll("e","i");
        // me das el conjunto de elementos cortados por un caracter indicaro
        palabra.split(""); // ["esto","es","un","ejemplo",""]
        // me indica si la palabra esta contenida el origen
        palabra.contains("ejemplo");
        // me indica el subconjunto de una palabra
        palabra.substring(0,5); // Esto e
        palabra.substring(5); // s un ejemplo de frase para analizar
        // saber si una palabra es igual a otra
        palabra = "Ejemplo";
        if (palabra.equalsIgnoreCase("ejemplo")){}
        palabra.toLowerCase();
        palabra.toUpperCase();
        // obtengo el char de una posicion concreta;
        palabra.charAt(palabra.length()-1);
        palabra = String.format("Esto es un %s de %s formateada","ejemplo","palabra");
        //System.out.printf("Esto es un formateo %s","formato");

        palabra = "Esto es una frase para poder analizar la palabra desde java";
        // sacar todas las letras de la palabra
        /*for (int i = 0; i < palabra.length(); i++) {
            System.out.println((int)(palabra.charAt(i)));
        }*/
        // cuantas palabras tengo
        int numeroPalabras = palabra.split(" ").length;
        System.out.println("el numero de palabras es "+numeroPalabras);
        // cuantas letras tengo
        int contador = 0;
        String[]palabras = palabra.split(" ");
        //[Esto,es,un,ejemplo,de,frase]
        for ( String item: palabras ) {
            contador+= item.length();
        }
        System.out.println("El numero de letras es "+contador);
        palabra = "Esto es una frase para poder analizar la palabra desde java";
        palabra = palabra.replaceAll(" ","");
        System.out.println(palabra.length());
        String frase = "Esto es un ejemplo. De una frase para poder analizar. En la clase de programacion" +
                "en el ciclo de DAW";
        // Cuantas oraciones tengo -> split(".")
        // Cuantas palabras tiene cada oracion
        String[] oraciones = frase.split("\\.");
        // Esto es un ejemplo.
        // De una frase para poder analizar.
        // En la clase de programacion en el ciclo de DAW
        System.out.println("El numero de oraciones es: "+oraciones.length);
        for ( String item: oraciones ) {
            int numeroPalabrasOracion = 0;
            numeroPalabrasOracion += item.split(" ").length;
            System.out.println("El numero de palabras de la oreacion es "+numeroPalabrasOracion);
        }







    }
}
