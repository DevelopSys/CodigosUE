package ejercicio2;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, sexo;
        int edad, altura, peso;
        double imc = 0.0;

        System.out.println("Dime tu nombre");
        nombre = scanner.next();
        System.out.println("Dime tu apellido");
        apellido = scanner.next();
        System.out.println("Dime tu edad");
        edad = scanner.nextInt();
        System.out.println("Dime tu altura en cm");
        altura = scanner.nextInt();
        System.out.println("Dime tu peso");
        peso = scanner.nextInt();
        System.out.println("Dime tu sexo (M/F)");
        sexo = scanner.next();

        imc = calculoIMC(peso,altura);

        System.out.printf("Hola %s tu IMC teniendo en cuenta tu altura de %d cm y tu peso de %d kg, tiene un valor de %.2f %n",
                nombre,altura,peso,imc);

        if (sexo.equalsIgnoreCase("m")){
            if (imc>10 && imc<20){
                System.out.println("Por debajo de tu peso");
            } else if( imc>=20 && imc<25){
                System.out.println("de tu peso");
            }
        } else {
            if (imc>10 && imc<23){
                System.out.println("Por debajo de tu peso");
            } else if( imc>=23 && imc<26){
                System.out.println("de tu peso");
            }
        }



    }

    public static double calculoIMC(int peso, int altura){
        // peso / altura(m) 2
        double imc = peso / Math.pow(((double) altura/100),2);
        return imc;
    }
}
