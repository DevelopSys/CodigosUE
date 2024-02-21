import controller.Concesionario;
import model.*;

public class Entrada {

    public static void main(String[] args) {
        // Vehiculo vehiculo = new Vehiculo(1,"Ford","Focus",200,2000);
        //vehiculo.mostrarDatos();
        Vehiculo deportivo = new Deportivo(2, "Ford", "GT40", 5000, 500, 400);
        Vehiculo electrico = new Electrico(3, "Tesla", "S", 2000, 200, 600);
        Vehiculo todoterreno = new Todoterreno(4, "Suzuki", "Virara", 4000, 300, "total");
        Vehiculo motoCarretera = new MotoCarretera(5, "Honda", "CBR", 4000, 300, "Carretera");
        Concesionario concesionario = new Concesionario();


        concesionario.agregarVehiculo(deportivo);
        concesionario.agregarVehiculo(electrico);
        concesionario.agregarVehiculo(todoterreno);
        concesionario.agregarVehiculo(motoCarretera);

        concesionario.acelerarStock();
        concesionario.activarCaracterisctica();



    }
}
