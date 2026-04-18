import exception.SaldoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestor {

    // POSIBLE FALLO -> NULLPOINTEREXCEPTION
    public void obtenerLetrasNombre() throws Exception {

        String nombre = null;
        System.out.println("El numero de letras de mi nombre es " + nombre.length());
    }

    // POSIBLE FALLO -> INDEXOUTOFBOUNDS - INPUTMISMATCH
    public void obtenerAsignaturaFav() throws IndexOutOfBoundsException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica tu asignatura favorita");
        int posicion = scanner.nextInt();
        String[] asignaturas = {"Programacion", "Lenguaje de Marcas", "Sistemas", "Fundamentos"};
        System.out.println("Tu asignatura favorita es " + asignaturas[posicion]);
    }

    public void lanzarExcepcion() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica de que equipo eres");
        String equipo = scanner.next();
        if (equipo.equals("madrid")){
            throw new Exception("Esto no puede pasar");
        }
        System.out.println("Este es el equipo bueno");
    }

    public void sacarDinero(){
        int saldo = 5000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica cuanta pasta quieres sacar del banco");
        int dinero = scanner.nextInt();
        if(saldo<dinero){
         throw new SaldoException("No hay saldo suficiente");
        }
        System.out.println("Fenomenal, has sacado el dinero y te quedan "+(saldo-dinero));
    }
}
