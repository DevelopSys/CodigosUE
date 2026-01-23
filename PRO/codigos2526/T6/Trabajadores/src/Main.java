import controller.Empresa;
import model.Director;
import model.Jefe;
import model.Trabajador;

import java.util.Scanner;

public class Main {
    // el metodo que actua como entrada el programa
    public static void main(String[] args) {
        /*
        System.out.println("Empezamos con la ejecucion del programa de gestion de trabajadores");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor indica el nombre de la empresa");
        String nombreEmpresa = scanner.next();

        System.out.println("Procedemos a realizar las nominas de la empresa "+nombreEmpresa);
        System.out.println("Indica el nombre del usuario");
        String nombre= scanner.next();
        System.out.println("Indica el apellido del usuario");
        String apellido= scanner.next();
        System.out.println("Indica el dni del usuario");
        String dni= scanner.next();
        Trabajador borja = new Trabajador(nombre, apellido, dni, 20000,12);
        Jefe pablo = new Jefe();
        Jefe marta = new Jefe("marta","lopez",5,10);
        Jefe juan = new Jefe("Juan", "Gonzalez");
        Director director = new Director();
        // nombre = null apellido = null
        Director director1 = new Director("Borja", "Martin");
        // nombre = Borja apellido = MArtin
        /*
        if (borja.getSalario()>15000 && borja.getNumeroPagas()<14){
            System.out.println("El trabajador tiene que hacer la renta");
        }
        System.out.println("Vamos a subirle el salario a borja en 2000");
        borja.setSalario(borja.getSalario()+2000);
        /*
        Trabajador borja = new Trabajador();
        // nombre=null apellido=null dni=null salario=0.0 irpf=0 nPagas=0
        Trabajador julia = new Trabajador("Julia","Lopez","12345A");
        // nombre=Julia apellido=Lopez dni=1235A salario=0.0 irpf=0 nPagas=0
        Trabajador alex = new Trabajador("Alejandro","Gomez","12345B",40000,12);
        // nombre=Alejandro apellido=Gomez dni=12345B salario=40000.0 irpf=0 nPagas=12
        Trabajador marta = new Trabajador("Marta","Liu","12345c",12,14,50000);
         */
        /*Director director =new Director("Borja", "Martin");
        Jefe jefe = new Jefe("Jefe1","Apellido1");
        Trabajador trabajador1 = new Trabajador("Trabajador1","Apellido1","1234A",30000.0,12);
        Trabajador trabajador2 = new Trabajador("Trabajador2","Apellido2","2345A",21,15,10000.0);
        trabajador2.mostrarDatos();*/
        // irpf =  experiencia =
        /*director.dirigirMasas("Hola que tal");
        director.dirigirMasas("Vamos a programar");
        director1.dirigirMasas("Vamos todos a clase");*/

        Empresa empresa = new Empresa("Informatica paco","España");
        empresa.contratarDirector(new Director("Paco","Jimenez"));
        // empresa.contratarDirector(new Director("Luis","Gomez"));
        empresa.mostarInformacion();
        // trabajadores = null
        // si una empresa no tiene jefe es porque jefe es null
        // director = null
    }
}
