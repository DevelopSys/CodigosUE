package ejercicio2;

import ejercicio2.model.Circulo;
import ejercicio2.model.Figura2D;
import ejercicio2.model.Rectangulo;
import ejercicio2.model.Triangulo;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {

        ArrayList<Figura2D> figuras2D = new ArrayList<>();
        figuras2D.add(new Circulo("circulo",2));
        figuras2D.add(new Triangulo("triangulo",2,4,5));
        figuras2D.add(new Rectangulo("Rectangulo",2,4));
        figuras2D.get(0).equals(figuras2D.get(2));

        for ( Figura2D figura2D:  figuras2D){
            System.out.println(figura2D.toString());
            figura2D.calcularPerimetro();
            System.out.println(figura2D.getPerimetro());
        }
    }
}
