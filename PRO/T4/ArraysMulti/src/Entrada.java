import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        //int[] carton = new int[10]; // 0 0 0 0 0 0 0 0 0 0
        int[] carton = new int[]{1, 23, 123, 123, 4, 56, 4, 3}; // 0 0 0 0 0 0 0 0 0 0
        //boolean[] aciertos = new boolean[10]; // false false false fals false
        boolean[] aciertos = new boolean[]{false, true, true,}; // false false false fals false
        //String[] palabras = new String[5]; // null null null null null
        String[] palabras = new String[]{"hola", "adios"}; // null null null null null
        //Object[] cosas = new Object[2]; // null null
        Object[] cosas = new Object[]{4, false, "hola", 'a'}; // null null

        // array multidimensional -> unas fila con unas columnas
        int[][] matriz = new int[3][3];
        // matriz.length -> numero de filas -> 5
        // matriz[0].length -> numero de columnas de la fila 2 -> 3
        /*
         * 6  9  1
         * 0  0  0
         * 0  0  0
         * */
        int[][] matrizRellena = new int[][]{{4, 6, 9, 10}, {4, 7, 23, 14}, {3, 23, 43, 16}, {65, 78, 34, 25}};
        /*
         * 4  6  9  10
         * 4  7  23  14
         * 3  23  43  16
         * 65  78  34  25
         * */
        // asignar un valor a una posicion de la matriz
        matriz[1][1] = 20;
        // acceder a una posicion de la matriz
        //System.out.println(matriz[1][1]);
        // cambiar todos los valores
        for (int i = 0; i < matriz.length; i++) {
            // recorro las filas -> [0, matriz.legth)
            for (int j = 0; j < matriz[i].length; j++) {
                // recorro las columnas -> [0, matriz[i].length)
                matriz[i][j] = (int) (Math.random() * 99) + 1;
            }
        }

        // recorrer todos los elementos
        /*for (int i = 0; i < matriz.length; i++) {
            // recorrer las filas
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }*/

        // ( lo que me encuentro en cada vuelta : lo que quiero recorrer )
        for (int[] fila : matriz) {
            for (int item : fila) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        System.out.println("Terminada impresion de la matriz");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime que numero quieres buscar en la matriz");
        int numeroBuscar = scanner.nextInt();

        // buscar cosas dentro de la matriz
        boolean encontrado = false;
        for (int[] fila : matriz) {
            for (int item : fila) {
                if (item == numeroBuscar) {
                    encontrado = true;
                    break;
                }
            }
        }
        // encontrado = false

        if (encontrado) {
            System.out.println("El numero buscado esta en la matriz");
        } else {
            System.out.println("El numero buscado no esta en la matriz");
        }

        // [x, ,x]
        // [ ,x, ]
        // [x, ,x]

        // dime en que fila y columna quieres colocar
        // 2 0
        // 2 1
        // 2 2

        // 0 0
        // 1 1
        // 2 2

        // 0 2
        // 1 1
        // 2 0

    }

    public static boolean buscarDato(int numero, int[][]matriz){
        boolean encontrado = false;
        for (int[] fila : matriz) {
            for (int item : fila) {
                if (item == numero) {
                    return true;
                }
                System.out.println("Ejecucion de columna");
            }
            System.out.println("Ejecucion de fila");
        }

        return false;
    }
}
