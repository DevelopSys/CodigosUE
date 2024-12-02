public class Ejercicios {

    public static void main(String[] args) {
        // sorteo de la champion
        String[] bombo1 = {"Barcelona", "Madrid", "Juve", "PSG", "Liverpol","PSV","Brest"};
        String[] bombo2 = {"Girona", "Bayer", "City", "Arsenal","Feyenord","Milan","Inter"};

        // como sacar todos los emparejamientos, no se pueden repetir equipos
        // Math.random()*bombo.length

        for (int i = 0; i < bombo1.length; i++) {
            int aleatorio1;
            do {
                aleatorio1 = (int) (Math.random() * bombo1.length);
                //5
            } while (bombo1[aleatorio1] == null);
            String equipo1 = bombo1[aleatorio1];
            bombo1[aleatorio1] = null;
            int aleatorio2;
            do {
                aleatorio2 = (int) (Math.random() * bombo2.length);
            } while (bombo2[aleatorio2] == null);
            String equipo2 = bombo2[aleatorio2];
            bombo2[aleatorio2] = null;
            System.out.printf("el emparejamiento es: %s vs %s\n", equipo1, equipo2);
            // %s
            // %d
            // %.2f
        }

    }
}
