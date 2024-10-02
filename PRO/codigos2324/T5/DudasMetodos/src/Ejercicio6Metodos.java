public class Ejercicio6Metodos {

    /*
    * (GeneradorPalabras) Crea un programa que cumpla los siguientes requisitos:
    - Crear un de chars con todas las letras del abecedario.
    - Crear un array de String con una longitud pedida por teclado
    - Pedir la longitud de cada una de las palabras que formarán parte del array del apartado 2. Tras pedir la longitud se creará una
     palabra de forma aleatoria con la longitud deseada (cada letra será una posición del array del apartado 1) y se guardará en el array del apartado 2
    - Imprimir por pantalla las palabras generadas*/

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String  palabraGenerada = generarPalabra(generarAbecedario(), (int) (Math.random()*10));
            //palabraGenerada = generarPalabra(generarAbecedario(),10);
            //palabraGenerada = generarPalabra(generarAbecedario(),5);
            System.out.println(palabraGenerada);
        }
    }

    public static char[] generarAbecedario(){
        char[] letras= new char[]{'A','B','C','D','E','F','G','H','I','J'};
        return letras;
    }

    public static String generarPalabra(char[] l,int longitud){
        // 10
        // ABCDE
        String palabra = "";
        for (int i = 0; i < longitud; i++) {
            char letra = l[(int) (Math.random()*longitud)];
            palabra+=letra;
        }

        return palabra;
    }
}
