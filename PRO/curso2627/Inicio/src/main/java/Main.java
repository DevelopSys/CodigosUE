public class Main {

    static String nombre = "Borja";
    static Character letraWr = 'B';
    static char letraDNI = 'A';
    static Integer edadInt = 42;
    static final int edad = 42;
    static double altura = 1.72;
    static boolean acierto = false;

    public static void main(String[] args) {
        metodo();
    }

    public static void metodo() {


        System.out.println("Mi nombre es " + nombre);
        nombre = "Borja M";
        // edad = edad +20;
        System.out.println("La edad es " + edad);
        System.out.println("Mi altura es "+altura);
        System.out.println("Mi letra del DNI es "+letraDNI);
        System.out.println("El acierto es  "+acierto);
    }
}
