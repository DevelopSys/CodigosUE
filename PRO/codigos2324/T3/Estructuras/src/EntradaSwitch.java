import java.util.Scanner;

public class EntradaSwitch {

    public static void main(String[] args) {
        System.out.println("Iniciando programa");
        // valor - int, char, string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce numero");
        int numero = scanner.nextInt();
        String palabra = "hola";
        char letra = 'R';
        //6
        // 1 ->
        // 4 ->
        // 6 ->
        // otro->
        switch (numero) {
            case 1:
                //String saludo = "Hola que tal estas";
                System.out.println("El valor es 1");
                break;
            case 4:
                //saludo = "asdasd";
                //System.out.println(saludo);
                System.out.println("El valor es 4");
                break;
            case 6:
                System.out.println("El valor es 6");
                break;
            default:
                System.out.println("No contemplado");
        }

        System.out.println("terminando programa");
    }
}
