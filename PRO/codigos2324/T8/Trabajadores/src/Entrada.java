import controller.Empresa;
import model.*;

public class Entrada {

    public static void main(String[] args) {

        // Persona persona1 = new Persona("123","Borja","corre@gmail.com");
        // persona1.mostrarDatos();
        Asalariado asalariado1 = new Asalariado("BorjaAsalariado1", "Martin", "correo@gmail.com", 10000, 14);
        Asalariado asalariado2 = new Asalariado("BorjaAsalariado2", "Martin", "correo@gmail.com", 10000, 14);
        Asalariado asalariado3 = new Asalariado("BorjaAsalariado3", "Martin", "correo@gmail.com", 10000, 14);
        Asalariado asalariado4 = new Asalariado("BorjaAsalariado4", "Martin", "correo@gmail.com", 10000, 14);
        Jefe jefe1 = new Jefe("BorjaJefe", "Martin", "correo@gmail.com", 60000,
                49, Puesto.gerencia);
        Trabajador jefe2 = new Jefe("LuisJefe", "Martin", "correo@gmail.com", 10000,
                49, Puesto.gerencia);
        Accionista accionista = new Accionista("BorjaAccionista", "Martin", "correo@gmail.com");

        jefe1.mostrarDatos();


        Empresa empresa = new Empresa();
        empresa.agregarPersona(asalariado1);
        empresa.agregarPersona(asalariado2);
        empresa.agregarPersona(asalariado3);
        empresa.agregarPersona(asalariado4);
        empresa.agregarPersona(jefe1);
        empresa.agregarPersona(jefe2);
        empresa.agregarPersona(accionista);

        //empresa.empezarJornadaLaboral();
        //empresa.realizarVotacion();
    }
}
