import model.Coche;

public class Entrada {

    // crear una aplicacion que permita gestionar coches
    // para el stock de un concesionario
    public static void main(String[] args) {
        // vista -> interaccion con el usuario
        // creo un coche
        // Tipo nombre = valor
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
        System.out.println(coche5.getModelo());*/
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

    }


}
