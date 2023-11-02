import java.util.Scanner;

public class EntradaIF {

    public static void main(String[] args) {


        // 5-10

        // suspenso - 1a4.99
        // ap 5a6.99
        // nt 7a8.99
        // sb 9a9.99
        // mh 10
        // 1-10
        System.out.println("Se esta ejecutando el programa");
        int nota = 10;
        if (nota>=1 && nota<=10){
            if (nota>=1 && nota<5){
                System.out.println("Has suspendido");
            } else if (nota>=5 && nota<7){
                System.out.println("La nota es ap");
            } else if (nota>=7 && nota<9) {
                System.out.println("La nota es nt");
            } else if (nota>=9 && nota<10) {
                System.out.println("La nota es ss");
            } else  {
                System.out.println("La nota es MH");
            }
        }
        else{
            System.out.println("Nota no valida");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero a evaluar");
        int numero = scanner.nextInt();
        // es par el numero
        // si se puede / 2 -> si el resto de dividir entre 2 es 0
        String saludo;
        if (numero%2==0){
            saludo = "Hola es un ejemplo";
            System.out.println("numero par");
            System.out.println(saludo);
        } else {
            saludo = "Otra cosa";
            System.out.println("numero impar");
        }
        System.out.println(saludo);

        // ternario condicion ? valor_true : valor_false
        String par = numero%2==0 ? "Es par" : "Es impar";
        System.out.println(par);
        System.out.println("Terminando programa");
    }
}
