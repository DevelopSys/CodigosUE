package controller;

import lombok.Getter;
import lombok.Setter;
import model.Director;
import model.Jefe;
import model.Trabajador;

import java.util.ArrayList;

@Getter
@Setter
public class Empresa {
    private String nombre, direccion;
    // array -> armario de tamaño fijo
    // List - ArrayList -> [e,e,e] -> armario de tamaño dinamico
    // Dictionary - HashMap -> par clave-valor -> armario de tamaño dinamico, sin indexacion
    private ArrayList<Trabajador> listaTrabajadores;
    private Director director;
    private ArrayList<Jefe> listaJefes;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        listaTrabajadores = new ArrayList<>();
        listaJefes = new ArrayList<>();
    }

    public void mostarInformacion() {
        System.out.println("El nombre de la empresa es " + this.nombre);
        System.out.println("La direccion de la empresa es " + this.direccion);
        System.out.println("El numero de trabajadores de la empresa " + listaTrabajadores.size());
        System.out.println("El numero de jefes de la empresa " + listaJefes.size());
        if (director != null) {
            System.out.println("El nombre del director de la empresa es " + director.getNombre());
        } else {
            System.out.println("La empresa aun no cuenta con director");
        }
    }

    public void contratarDirector(Director director) {
        // se asigna a la variable de arriba
        if (this.director == null) {
            this.director = director;
            System.out.println("Ya tenemos director!");
        } else {
            System.out.println("Lo siento, ya tenemos director");
        }
    }

    // quiero que hagais un metodo que permita contratar trabajadores
    public void contratarTrabajador(Trabajador trabajador) {
        // si tengo un trabajador con el mismo DNI, no se agrega
        // recorrer la lista y preguntar uno a uno
        boolean esta = false;
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i).getDni().equals(trabajador.getDni())) {
                esta = true;
                break;
            }
        }
        // esta = true

        if (esta) {
            System.out.println("El trabajador tiene un dni identico al de alguno de mis trabajadores");
        } else {
            System.out.println("Contrato al trabajador");
            listaTrabajadores.add(trabajador);
        }


    }

    // quiero que hagais un metodo que permita contratar jefes
    public void contratarJefe(Jefe trabajador) {
        // si tengo un trabajador con el mismo DNI, no se agrega
        // recorrer la lista y preguntar uno a uno

        System.out.println("Contrato al jefe");
        listaJefes.add(trabajador);


    }

    // quiero que hagais un metodo que permita mostrar toda la info de los trabajadores
    public void mostrarDatosTrabajadores() {
        // recorre la lista de los trabajadores
        // uno a uno le digo que ejecute una funcionalidades suya
        for (Trabajador trabajador : listaTrabajadores) {
            trabajador.mostrarDatos();
        }
    }

    public void mostrarInformacionJefes() {
        for (Jefe jefe : listaJefes) {
            jefe.mostarDatos();
        }
    }

    public void asignarResponsabilidad(String nombre, int reponsabilidad) {
        for (Jefe item : listaJefes) {
            if (item.getNombre().equals(nombre)) {
                item.setNivelResponsabilidad(reponsabilidad);
                break;
            }
        }
    }

    public void asignarTutor(String nombre){
        // asignar al jefe con nombre que te doy una persona mas a su cargo
        for (Jefe item: listaJefes) {
            if (item.getNombre().equals(nombre)){
                item.setPersonasCargo(item.getPersonasCargo()+1);
            }
        }
    }
    // quiero que hagais un metodo que permita mostrar toda la info de los jefes
}
