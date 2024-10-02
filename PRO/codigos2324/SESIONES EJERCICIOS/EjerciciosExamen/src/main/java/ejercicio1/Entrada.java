package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Entrada {

    /*1.	Realizar un programa que pida por teclado las 20 notas de todos los alumnos de una clase y las guarde dentro de una colección. (Puede ser array o arraylist) Al finalizar, imprimir por pantalla los siguientes datos:
    a.	La nota más alta obtenida
    b.	La nota más baja obtenida
    c.	La cantidad de aprobados
    d.	La cantidad de suspensos
    e.	La nota media*/

    public static void main(String[] args) {

        ArrayList<Integer> notas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double media = 0.0;
        int aprobados = 0;
        int suspensos = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce nota");
            int nota = scanner.nextInt();
            notas.add(nota);
            if (nota>=5){
                aprobados++;
            } else if (nota<5) {
                suspensos++;
            }
            media +=nota;
        }


        Collections.sort(notas);
        // Arrays.sort();

        System.out.printf("La media es %.2f %n",media/notas.size());
        System.out.printf("El numero de aprobados es  %d %n",aprobados);
        System.out.printf("El numero de suspensos es  %d %n",suspensos);
        System.out.printf("La nota mas alta es %d %n",notas.get(notas.size()-1));
        System.out.printf("La nota mas baja es %d %n",notas.get(0));

    }

}
