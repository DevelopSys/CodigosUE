import java.util.Scanner;

public class Boletin {

    public static void main(String[] args) {

        // registrar participantes
        // nombre, apellido, marcaTiempo
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos participantes quieres");
        int nParticipantes = scanner.nextInt();
        Object[][] participantes = new Object[nParticipantes][3];

        for (int i = 0; i < nParticipantes; i++) {
            //String nombr
            Object[] participante = {"Borja","Martin",12};
            participantes[i] = participante;
        }


        /*Object[] participante2 = {"Juanjo","Martin",24};
        Object[] participante3 = {"Luis","Martin",34};
        Object[] participante4 = {"Borja","Herrera",44};
        participantes[0] = participante1;
        participantes[1] = participante2;
        participantes[2] = participante3;
        participantes[3] = participante4;*/

        // imprimir participantes
        /*for ( Object[] item : participantes ) {
            System.out.println("Los datos del participante: "+item[0].toString());
            for ( Object element : item) {
                System.out.println("\tEl dato es: "+element);
            }

        }*/

        // buscarlo
         /*String nombre = "Juanjo";
        for ( Object[] item : participantes ) {
            if (item[0].toString().equalsIgnoreCase(nombre)){
                System.out.println("Los datos del participante: "+item[0].toString());
                for ( Object element : item) {
                    System.out.println("\tEl dato es: "+element);
                }
            }

        }*/

        // eliminar
        String nombre = "Luis";
        for ( Object[] item : participantes ) {
            if (item[0].toString().equalsIgnoreCase(nombre)){
               item = null;
            }
        }

        for (int i = 0; i < participantes.length; i++) {

            if (participantes[i][0].toString().equalsIgnoreCase(nombre)){
                participantes[i]=null;
            }

        }


        for ( Object[] item : participantes ) {
            if (item!=null){
                System.out.println("Los datos del participante: "+item[0].toString());
                for ( Object element : item) {
                    System.out.println("\tEl dato es: "+element);
                }
            }
        }
    }
}
