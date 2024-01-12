public class Entrada {

    public static void main(String[] args) {

        Operaciones operaciones = new Operaciones();
        double resultado = operaciones.dividir(4,2) * operaciones.sumar(4,4);
        System.out.println(resultado);
        System.out.println(operaciones.generarAleatorio(200));
        System.out.println(operaciones.generarAleatorio(400));
        System.out.println(operaciones.generarAleatorio(500));

        int[] numeros = new int[]{1, 123, 123, 134, 56, 3, 2, 34, 5, 32, 3, 45, 3, 4};
        int[][] numerosMulto = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {5, 6, 7, 8}};

        for (int i = 10; i < 20; i++) {
            if (encontrarNumero(numeros,i)) {
                // logica cuando lo has encontrado
            } else {
                // logica cuando no lo has encontrado
            }
        }
        //int resultado = sumar(6, 7) * 2; // 13*2
        //System.out.println(sumar(16, 17) * 2);
        ; // 33*2
    }

    public static boolean encontrarNumero(int[] coleccion, int numero) {
        for (int item : coleccion) {
            if (item == numero) {
                return true;
            }
        }
        return false;
    }

    public static boolean encontrarNumero(int[][] coleccion, int numero) {
        for (int[] fila : coleccion) {
            for (int item : fila) {
                if (item == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int sumar(int a, int b) {
        // 20mil lineas
        int suma = a + b;
        return suma;
        //System.out.println("La suma es " + suma);
    }


}
