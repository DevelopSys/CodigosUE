import java.util.Scanner;

public class EntradaSeleccion {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // estructuraIF();
        // estructuraSwitch();
    }

    private static void estructuraSwitch() {
        System.out.println("Indicame tu mes de nacimiento");

        int mes = scanner.nextInt();
        // enero,mayo, julio, octubre, diciembre, agosto, marzo -> 31
        // abril, junio, seleptiembre, noviembre -> 30
        // febrero -> 28
        String nombre = "Borja";
        switch (nombre) {
            case "Borja":
                break;
            case "Pedro":
                break;
        }
        switch (mes) {
            case 1, 3, 5, 7, 8:
                System.out.println("Este mes tiene 31 dias");
                break;
            case 2:
                System.out.println("Este mes  tiene 28 dias");
                break;
            case 4, 11, 6, 9:
                System.out.println("Este mes tiene 30 dias");
                break;
            default:
                System.out.println("Mes no valido");
        }
        System.out.println("Terminando");
    }
    public static void estructuraIF() {
        // seleccion dependendiendo de un valor T o F
        // 0-4 ss
        // 5-6 ap
        // 7-8 nt
        // 9 sb
        // 10 mh
        System.out.println("Dime que nota quieres evaluar");
        double nota = scanner.nextDouble();
        // 4
        if (nota >= 0 && nota <= 10) {
            if (nota < 5) {
                System.out.println("EL examen esta SS");
            } else if (nota <= 6) {
                System.out.println("EL examen esta AP");
            } else if (nota <= 8) {
                System.out.println("EL examen esta NT");
            } else if (nota < 10) {
                System.out.println("El examen esta SB");
            } else {
                System.out.println("El examen esta de 10");
            }
        } else {
            System.out.println("Nota no valida");
        }

    }

}
