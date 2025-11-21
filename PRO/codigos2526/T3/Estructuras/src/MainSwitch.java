import java.util.Scanner;

public class MainSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica la nota que has sacado en el examen");
        int nota = scanner.nextInt();
        switch (nota) {
            case 1, 2, 3, 4 -> {
                System.out.println("El examen es suspenso");
                System.out.println("Cuantas horas has estudiado");
                int horas = scanner.nextInt();
                if (horas > 4) {
                    System.out.println("El siguiente seguro que lo apruebas");
                } else {
                    System.out.println("Ponte las pilas");
                }

            }
            case 5, 6, 7 -> {
                System.out.println("El examen esta aprobado");
            }
            case 8, 9 -> {
                System.out.println("El examen esta notable");
            }
            case 10 -> {
                System.out.println("El examen esta sobresaliente");
            }
            default -> {
                System.out.println("Nota no valida");
            }
        }

        System.out.println("indica el mes del año actual");
        String mes = scanner.next();
        switch (mes.toLowerCase()){
            case "enero","febrero","marzo":
                System.out.println("Estas en invierno");
                break;
            case "abril","mayo","junio":
                System.out.println("Estas en primavera");
                break;
            case "julio","agosto","septiembre":
                System.out.println("Estas en verano");
                break;
            case "noviembre","diciembre":
                System.out.println("Estas en otoño");
                break;
            default:
                System.out.println("Mes no contemplado");
        }

        System.out.println("Fin de la evaluacion de los meses");
    }
}
