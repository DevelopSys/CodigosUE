import javax.swing.plaf.PanelUI;
import java.util.Scanner;

public class Ejercicio2 {

    /*
    Ejercicio 2. Hágase un programa que lea 5 variables enteras y haga lo siguiente:

a) Las muestre en una línea separadas por un espacio.

b) Rote los valores hacia la izquierda (la primera variable tome el valor de la segunda; la segunda, la de la tercera; la tercera, la de la cuarta; la cuarta, la de la quinta; y la quinta, la de la primera.

c) Se muestren de nuevo el valor de las cinco variables de la misma forma que en el apartado a).
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor introduce tu nombre");
        String nombre = scanner.next();
        System.out.println("Introduce numero 1");
        int numero1 = scanner.nextInt();
        System.out.println("Introduce numero 2");
        int numero2 = scanner.nextInt();
        System.out.println("Introduce numero 3");
        int numero3 = scanner.nextInt();
        System.out.println("Introduce numero 4");
        int numero4 = scanner.nextInt();
        System.out.println("Introduce numero 5");
        int numero5 = scanner.nextInt();

        System.out.println("Me has dicho que te llamas: "+nombre);
        System.out.println(numero1+" "+numero2+" "+numero3+" "+numero4+" "+numero5);
        // 1 2 3 4 5
        int aux = numero1;
        numero1=numero2; // n1 =2
        numero2=numero3; // n2 =3
        numero3=numero4; // n3 =4
        numero4= numero5; //n4= 5
        numero5=aux; // n5 =1


        System.out.println(numero1+" "+numero2+" "+numero3+" "+numero4+" "+numero5);
        // 2 3 4 5 1

        aux = numero5;
        numero5 = numero4;
        numero4 = numero3;
        numero3 = numero2;
        numero2 = numero1;
        numero1 = aux;
        // 1 2 3 4 5
        System.out.println(numero1+" "+numero2+" "+numero3+" "+numero4+" "+numero5);

        int resto = 24690%3600;

        // 24690 / 3600 = 6horas y 0.85 horas
        // 3600 segundos en 1 hora
        // 60 minutos en 1 hora
        // 60 segundos en 1 minuto

    }

    public void metodoEjemplo(){
        System.out.println("Imprime el pedir cosas");
    }

}
