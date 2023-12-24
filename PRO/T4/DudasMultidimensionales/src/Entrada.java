public class Entrada {

    static int[][] cuadradoMagico = new int[4][4];
    static boolean esMagico = true;
    static int sumaMagica = 0, sumaAuxiliar = 0;

    public static void main(String[] args) {

        // rellenar el array multidimensional
        //rellenarCuadrado();
        // mostrar cuadrado
        //mostrarCuadrado();
        // es magico???? suma fila 1,2,3 suma columna 1,2,3 suma diagonal 1,2 = iguales

        // 1   3   5
        // 4   2   4
        // 1   2   4

        // 1 1 1
        // 1 1 1
        // 1 1 1


        // sumo todos los elementos de la 1º fila y anoto el numero
        // sumo los elementos de la segunda fila y miro si el numero coincide con el de arriba
        // sumo los elementos de la tercera fila y miro si el numero coincide con el de arriba
        // sumo los elementos de la cuarta fila y miro si el numero coincide con el de arriba
        // sumo los elementos de la primera columna y miro si el numero coincide con el de arriba
        // sumo los elementos de la segunda columna y miro si el numero coincide con el de arriba
        // sumo los elementos de la tercera columna y miro si el numero coincide con el de arriba
        // sumo los elementos de la primera diagonal y miro si el numero coincide con el de arriba
        // sumo los elementos de la segunda diagonal y miro si el numero coincide con el de arriba

        // si todos coinciden ES MAGICO
        // sino no es MAGICO


        do {
            esMagico = true;
            rellenarCuadrado();
            mostrarCuadrado();

            // comprobar filas
            for (int i = 1; i < cuadradoMagico.length; i++) {
                // contar filas
                sumaAuxiliar = 0;
                for (int j = 0; j < cuadradoMagico[i].length; j++) {

                    sumaAuxiliar += cuadradoMagico[i][j];
                    if (sumaAuxiliar != sumaMagica && j == cuadradoMagico[i].length - 1) {
                        // no es magico
                        esMagico = false;
                        break;
                    }
                }
                System.out.println("Suma auxiliar es " + sumaAuxiliar);
                if (!esMagico) {
                    break;
                }
            }


        /*int sumaColumna1=0,sumaColumna2=0,sumaColumna3 = 0;
        for (int i = 0; i <=cuadradoMagico[0].length ; i++) {
            sumaColumna1 = sumaColumna1 + cuadradoMagico[i][0];
        }
        for (int i = 0; i <=cuadradoMagico[0].length ; i++) {
            sumaColumna2 = sumaColumna2 + cuadradoMagico[i][1];
        }
        for (int i = 0; i <=cuadradoMagico[0].length ; i++) {
            sumaColumna3 = sumaColumna3 + cuadradoMagico[i][2];
        }


        if (sumaColumna1==sumaColumna2 && sumaColumna1==sumaColumna3){
            System.out.println("El cuadrado es magico");

        } else {
            rellenarCuadrado();
        }*/


        } while (!esMagico);
        // EL CUADRADO ES MAGICO
        System.out.println("El cuadrado mágico es");
        mostrarCuadrado();
    }


    public static void rellenarCuadrado() {
        for (int i = 0; i < cuadradoMagico.length; i++) {
            // recorrer las filas
            for (int j = 0; j < cuadradoMagico[i].length; j++) {
                // escribir en una columna
                int aleatorio;
                do {
                    aleatorio = (int) (Math.random() * 40);
                } while (estaNumero(aleatorio));
                // ¿ya esta en el cuadrado?
                cuadradoMagico[i][j] = aleatorio;
            }
        }
        calcularSumaMagica();
    }

    public static boolean estaNumero(int numero) {
        for (int[] fila : cuadradoMagico) {
            for (int item : fila) {
                if (item == numero) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void mostrarCuadrado() {
        for (int[] fila : cuadradoMagico) {
            for (int item : fila) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void calcularSumaMagica() {
        sumaMagica = 0;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            sumaMagica += cuadradoMagico[0][i];
        }
        System.out.println("La suma mágica es " + sumaMagica);
    }

}
