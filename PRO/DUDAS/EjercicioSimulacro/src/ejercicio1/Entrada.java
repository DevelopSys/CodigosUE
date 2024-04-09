package ejercicio1;

import ejercicio1.util.*;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String nombre=null, apellido=null, mail=null, dni=null;
        boolean salir = false;
        do {
            System.out.println("1. Introduce nombre");
            System.out.println("2. Introduce apellido");
            System.out.println("3. Introduce dni");
            System.out.println("4. Introduce email");
            System.out.println("5. Salir");
            System.out.println("Que opcion quieres realizar");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Caso nombre");
                    System.out.println("Introduce nombre");
                     nombre = scanner.next();
                    for (int i = 0; i < nombre.length(); i++) {
                        boolean isDigit = Character.isDigit(nombre.charAt(i));
                        if (isDigit) {
                            try {
                                throw new TipoDatoIncorrectoException("Hay un dato incorrecto");
                            } catch (TipoDatoIncorrectoException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Caso apellido");
                    System.out.println("Introduce apellido");
                     apellido = scanner.next();
                    for (int i = 0; i < apellido.length(); i++) {
                        boolean isDigit = Character.isDigit(apellido.charAt(i));
                        if (isDigit) {
                            try {
                                throw new TipoDatoIncorrectoException("Hay un dato incorrecto");
                            } catch (TipoDatoIncorrectoException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Caso dni");
                    System.out.println("introduce dni");
                     dni = scanner.next();
                    int longitud = dni.length();
                    try {
                        if (longitud != 9) {
                            throw new LongitudDNINoValidaException("Longitud invalida");
                        }
                        for (int i = 0; i < dni.length() - 1; i++) {
                            boolean isDigit = Character.isDigit(dni.charAt(i));
                            if (!isDigit) {
                                throw new NumeracionContieneLetrasException("Hay un numero en el dni");
                            }
                        }
                        boolean isDigit = Character.isDigit(dni.charAt(dni.length() - 1));
                        if (isDigit) {
                            throw new UltimoDigitoNoLetraException("El ultimo digito no es una letra");
                        }
                    } catch (LongitudDNINoValidaException e) {
                        System.out.println(e.getMessage());
                    } catch (NumeracionContieneLetrasException e) {
                        System.out.println("Hay un fallo de dni");
                    } catch (UltimoDigitoNoLetraException e) {
                        System.out.println("Hay un fallo de dni");
                    }
                    System.out.println("Comprobacion terminada");
                    break;
                case 4:
                    System.out.println("Caso email");
                    System.out.println("Introduce email");
                     mail = scanner.next();
                    if (!mail.contains("@") || !mail.contains(".")){
                        try {
                            throw new EmailIncorrectoException("Email mal formateado");
                        } catch (EmailIncorrectoException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Comprobar si puedo salir");
                    if (nombre!=null && apellido !=null && dni !=null && mail!=null ){
                        salir=true;
                    }
                    break;
            }
        } while (opcion != 5 || !salir);
    }
}
