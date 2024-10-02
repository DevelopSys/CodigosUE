public class Ejercicio2 {

    public static void main(String[] args) {

        int variable1 = 4;
        int variable2 = 34;
        int variable3 = 12;
        int variable4 = 54;
        int variable5 = 24;

        System.out.println(variable1 +" "+variable2 +" "+variable3 +" "+variable4 +" "+variable5);

        int aux = variable1;

        variable1 = variable2;
        variable2 = variable3;
        variable3 = variable4;
        variable4 = variable5;
        variable5 = aux;

        System.out.println(variable1 +" "+variable2 +" "+variable3 +" "+variable4 +" "+variable5);

        aux = variable5;
        variable5 = variable4;
        variable4 = variable3;
        variable3 = variable2;
        variable2 = variable1;
        variable1 = aux;

        System.out.println(variable1 +" "+variable2 +" "+variable3 +" "+variable4 +" "+variable5);

    }
}
