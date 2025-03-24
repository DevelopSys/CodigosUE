import controller.Empresa;
import model.Asalariado;
import model.Autonomo;
import model.Persona;
import model.Trabajador;

public class Entrada {

    public static void main(String[] args) {
        Persona autonomo1 = new Autonomo("Celia1","Martin",234,150678,120);
        Persona autonomo2 = new Autonomo("Celia2","Martin",234,250678,220);
        Persona autonomo3 = new Autonomo("Celia3","Martin",234,350678,320);
        Persona asalariado1 = new Asalariado("Borja1", "Martin", 123, 1300000, 0.21, 12);
        Persona asalariado2 = new Asalariado("Borja2", "Martin", 123, 2300000, 0.31, 12);
        Persona asalariado3 = new Asalariado("Borja3", "Martin", 123, 3300000, 0.41, 12);
        Empresa<Persona> empresa = new Empresa();


        Empresa<Autonomo> empresa1 = new Empresa();
        Empresa<Asalariado> empresa2 = new Empresa();



        /*empresa.contratarPersona(asalariado1);
        empresa.contratarPersona(asalariado2);
        empresa.contratarPersona(asalariado3);
        empresa.contratarPersona(autonomo1);
        empresa.contratarPersona(autonomo2);
        empresa.contratarPersona(autonomo3);
        empresa.mostrarSueldos();*/
    }
}
