import java.util.Scanner;

public class EntradaTrabajador {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombre = lectorTeclado.next();
        System.out.println("Indica tu edad");
        int edad = lectorTeclado.nextInt();
        System.out.println("Cuanto dinero quieres ganar");
        int salario = lectorTeclado.nextInt();
        System.out.println("Tienes experiencia");
        boolean experiencia = lectorTeclado.nextBoolean();

        // edad sea inferior a 30 pero que no quiera ganar mas de 30000
        // edad sea superior a 40 pero no quiera ganar mas de 20000 y ademas cuente con experiencia
        boolean candidatoOptimo = (edad<30 && salario<30000) || (edad>40 && salario<=20000 &&experiencia);
        System.out.println("El candidato ha pasado el proceso "+candidatoOptimo);
    }
}
