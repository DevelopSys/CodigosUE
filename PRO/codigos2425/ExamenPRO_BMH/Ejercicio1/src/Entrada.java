import model.Coche;
import model.Moto;
import model.Vehiculo;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        ArrayList<Vehiculo> listaVehiculos = new ArrayList();

        listaVehiculos.add(new Coche("Mercedes","ClaseA",2010,3));
        listaVehiculos.add(new Coche("Mercedes","ClaseC",2015,6));
        listaVehiculos.add(new Moto("Suzuki","ZZR",2025,3000));
        listaVehiculos.add(new Moto("isuzu","JJV",2021,4000));

        for (Vehiculo item: listaVehiculos) {
            item.mostrarDatos();
            if (item instanceof Moto){
                ((Moto) item).metodoMoto();
            }
        }





    }
}
