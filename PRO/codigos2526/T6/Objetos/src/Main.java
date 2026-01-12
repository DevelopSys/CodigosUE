import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nombre = "asdasd";
        Scanner scanner = new Scanner(System.in);

        Coche ford = new Coche();
        // marca=null, modelo=null, color=null, combustible=null, precio=0, cv=0, etiqueta=0
        Coche opel = new Coche();
        // marca=null, modelo=null, color=null, combustible=null, precio=0, cv=0, etiqueta=0
        Coche coche3 = new Coche("Mercedes","ClaseC",300);
        // marca=Mercedes, modelo=ClaseC, color=null, combustible=null, precio=0, cv=300, etiqueta=0
        Coche coche4 = new Coche("Audi","Etron",500,150000);
        // marca=Audi, modelo=Etron, color=null, combustible=null, precio=150000, cv=500, etiqueta=0
        // coche4.setPrecio(60000);
        System.out.println(coche4.getPrecio());

    }
}
