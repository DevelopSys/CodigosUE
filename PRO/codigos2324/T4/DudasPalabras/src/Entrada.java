public class Entrada {

    public static void main(String[] args) {

        String[] palabras = new String[]{"asdasdasd","asdasdasdadadadasdasd","uasd","·asdasdasd","adasdasdasda","sdasdasd","dqweqweqweqewqwe"};

        int numeroLetras = 0;
        for (int i = 0; i < palabras.length; i++) {
            String item = palabras[i];
            numeroLetras += item.length();
        }
        System.out.println(numeroLetras);


        // numero de letras


        String palabra = "Esto es un ejemplo de una palabra";
        System.out.println(palabra.length());
        System.out.println(palabra.contains("a"));
        System.out.println(palabra.charAt(6));
        palabra = palabra+" Cosa concatenada";
        System.out.println(palabra);
        String letra = "E"; // Object
        System.out.println(letra);
        char letraCorrecta = 'E';
        boolean comparacion = palabra.equalsIgnoreCase("Esto es un ejemplo de una PALABRA");
        boolean comparacionLetras = letraCorrecta == 69;

        palabra = "agregar";
        switch (palabra){
            case "agregar":
                break;
            case "borrar":
                break;
        }

        letraCorrecta = 'C';
        switch (letraCorrecta){
            case 'C':
                break;
            case 'B':
                break;
        }


    }
}
