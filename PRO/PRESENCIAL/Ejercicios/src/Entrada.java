import java.util.Calendar;
import java.util.Scanner;

public class Entrada {


    // 1 -> 7 -> (40%) -> 2.8 (calculado)
    // 2 -> X -> (60%) -> (8.5 - 2.8) (calculado) = 6 - (40% del scanner)
    // FINAL     (100%)-> 8.5

    // 0.4 *7 + 0.6*X = 8.5
    // 2.8 + 0.6*x = 8.5
    // 0.6*x = (8.5 - 2.8)
    // x = (8.5 - 2.8) / 0.6


    public static void main(String[] args) {


        final String[] tiradas = new String[]{"Piedra","Papel","Tijera"};
        System.out.println("Indica cual es tu tirada");
        for ( String item: tiradas ) {
            System.out.println(item);
        }

        Scanner scanner= new Scanner(System.in);
        System.out.println("Cual es la tirada del J1");
        String tiradaJ1 = tiradas[scanner.nextInt()];
        System.out.println("Cual es la tirada del J2");
        String tiradaJ2 = tiradas[scanner.nextInt()];



        int examen1 = 7;
        double notaFinal = 8.5;

        // // 0.4 *7 + 0.6*X = 8.5
        double examen2 = (notaFinal - (examen1*0.4))/0.6;





        Calendar calendar = Calendar.getInstance();

        saludo(calendar.get(Calendar.HOUR_OF_DAY));
    }

    public static void saludo (int hora){

    }
}
