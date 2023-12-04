public class Entrada {

    public static void main(String[] args) {
        // do - while

        int[][] matriz = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // matriz[i][j]
            }
        }

        int[] carton = new int[10];
        // 5 7 6 1 0
        // [1-10]
        // 1


        for (int i = 0; i < carton.length; i++) {
            int numeroAleatorio;
            boolean repetido;
            do{
                repetido = false;
                numeroAleatorio = (int) (Math.random()*10)+1;
                for (int item: carton) {
                    if (item == numeroAleatorio){
                        repetido=true;
                        break;
                    }
                }
            }while (repetido);
            carton[i] = numeroAleatorio;
        }

        for (int i = 0; i < carton.length; i++) {
            System.out.println(carton[i]);
        }

    }
}
