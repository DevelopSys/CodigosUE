import controller.Taller;
import model.Coche;
import model.CocheLombok;
import model.Motor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Entrada {

    // main con poo simple
    /*
    // crear una aplicacion que permita gestionar coches
    // para el stock de un concesionario
    public static void main(String[] args) {
        // vista -> interaccion con el usuario
        // creo un coche
        // Tipo nombre = valor

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        /*Calendar calendar = Calendar.getInstance();

        calendar.get(Calendar.MINUTE);
        calendar.get(Calendar.HOUR);
        calendar.get(Calendar.SECOND);
        calendar.get(Calendar.DAY_OF_MONTH);

        // CocheLombok cocheLombok = new CocheLombok();

        Coche coche1 = new Coche();
        // atributos => marca=Ford, modelo=null, matricula=null,color=Amarillo, cv=150, precio=0.0
        coche1.setMarca("Ford");
        coche1.setCv(150);
        coche1.setColor("Amarillo");
        Coche coche2 = new Coche();
        // atributos => marca=Mercedes, modelo=null, matricula=null,color=null, cv=300, precio=0.0
        coche2.setMarca("Mercedes");
        coche2.setCv(300);
        Coche coche3 = new Coche("Mercedes","EQE",400);
        // atributos => marca=Mercedes, modelo=EQE, matricula=null,color=null, cv=400, precio=0.0
        Coche coche4 = new Coche("AUDI","RS8",600);
        // atributos => marca=Audi, modelo=RS8, matricula=null,color=null, cv=600, precio=0.0
        Coche coche5 = new Coche("Opel","Astra",130,30000);
        // atributos => marca=Opel, modelo=Astra, matricula=null,color=null, cv=130, precio=30000.0

        /*System.out.println(coche1.getModelo());
        System.out.println(coche2.getModelo());
        System.out.println(coche3.getModelo());
        System.out.println(coche4.getModelo());
        System.out.println(coche5.getModelo());
        // coche5.mostrarDatos();
        Coche[] garaje = new Coche[]{coche1,coche2,coche3,coche4,coche5};
        // c1,c2,c3,c4,c5
        for ( Coche item : garaje ) {
            item.setPrecio(item.getPrecio()+1000);
            // item.mostrarDatos();
        }
        System.out.println("Los precios han subido");
        for ( Coche item : garaje ) {
            System.out.println("Impimiendo datos del coche");
            item.mostrarDatos();
        }

    }*/

    // main con poo con objetos como variables en la clases
    public static void main(String[] args) {

        Taller taller = new Taller();
        Coche mercedes = new Coche("Mercedes","eqe",new Motor(500,4000));
        Coche opel1 = new Coche("Opel1","astra1",new Motor(100,6000));
        Coche opel2 = new Coche("Opel2","astra2",new Motor(200,6000));
        Coche opel3 = new Coche("Opel3","astra3",new Motor(301,6000));
        Coche opel = new Coche("Opel4","astra4",new Motor(200,6000));
        taller.pintarCoche(mercedes,"Amarillo");
        taller.pintarCoche(opel1,"Amarillo");
        taller.pintarCoche(opel2,"Negro");
        taller.recogerCoche("astra2");
        taller.pintarCoche(opel3,"Blanco");
        taller.pintarCoche(opel,"Blanco");
        // sin pintar

        // mercedes.mostrarDatos();
        System.out.println(taller.getCaja());
        /*
        // ArrayList<Objects> garaje = new ArrayList<>();
        Coche[] garaje = new Coche[]{mercedes,opel1,opel2,opel3,opel};

        // pone a todos los coches un precio de salida de 10000
        for ( Coche item : garaje ) {
            item.setPrecio(10000);
        }

        // aquellos coches que tengan mas de 300 CV, incrementa su precio en 30000
        for (Coche item: garaje) {
            if(item.getMotor().getCv()>300){
                item.setPrecio(30000+item.getPrecio());
            }
        }

        for ( Coche item : garaje ) {
            System.out.printf("\t\t\tDatos del %s %s%n",item.getMarca(),item.getModelo());
            item.mostrarDatos();
        }*/







    }

}
