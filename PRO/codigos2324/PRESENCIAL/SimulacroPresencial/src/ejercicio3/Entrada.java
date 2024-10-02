package ejercicio3;

import ejercicio3.model.Ingrediente;
import ejercicio3.model.Pizza;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce nombre de pizza");
        String nombre = scanner.next();
        Pizza pizza = new Pizza(nombre);
        String continuar = "";
        do {
            System.out.println("Introduce nombre ingrediente");
            String nombreIngrediente = scanner.next();
            System.out.println("Introduce precio ingrediente");
            int precio = scanner.nextInt();
            Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precio);
            pizza.agregarIngrediente(ingrediente);
            System.out.println("Quieres agregar mas ingredientes (y/n)");
            continuar = scanner.next();
        } while (continuar.equals("y"));

        pizza.mostrarDatos();

    }
}
