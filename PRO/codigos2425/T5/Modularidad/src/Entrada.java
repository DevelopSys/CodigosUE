import controller.Metodo;

public class Entrada {

    public static void main(String[] args) {
        // vista de la app
        // primitivos: int, doouble ,char, float, boolean
        // complejo: String

        Metodo metodos = new Metodo();
        Metodo metodos1 = new Metodo();
        // lineas
        // metodos.metodoSaludar();
        // System.out.println(metodos.realizarDivision()); // 2.0
        double resultado = metodos.realizarDivision(); // 4/2 -> 2.0
        resultado = metodos.realizarDivision(6); // 4/6 -> 0.0
        // resultado = metodos.; // 6/4 -> 1.0
        // System.out.println(resultado);
        String palabra = new String("Hola");
        System.out.println(palabra); // @F234E1B
        System.out.println(metodos);
        metodos.calcularMedia(new int[]{1,5,7,9,12,87,13});
        metodos.calcularMedia(new int[]{1,5,7});
        metodos.sacarDinero(1234,100);




    }
}
