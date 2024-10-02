import java.util.Scanner;

public class EntradaWhile {
    public static void main(String[] args) {

        int numero = -8;
        // 0 ejecuciones a n ejecuciones
        while (numero >= 0) {
            System.out.println("Ejecutando el bloque while");
            numero--;
        }
        // 1 ejecucion a n ejecuciones
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (opcion != 4);
        System.out.println("La opcion elegida es: "+opcion);
    }
}
