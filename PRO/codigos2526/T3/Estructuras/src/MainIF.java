import java.util.Scanner;

public class MainIF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica la nota que has sacado en el examen");
        int nota = scanner.nextInt();
        // 0-4.99 SS
        // 5-7.99 AP
        // 8-9.5 NT
        // 9.5-10 SB
        if (nota>=0 && nota<=10){
            if (nota<5){
                System.out.println("Examen suspenso");
            } else if(nota<8){
                System.out.println("Examen aprobado");
            } else if (nota<9.5) {
                System.out.println("Examen notable");
            } else {
                System.out.println("Examen sobresaliente");
            }
        }
        else {
            System.out.println("Nota invalida");
        }
        System.out.println("Terminando la evaluacion");
    }
}
