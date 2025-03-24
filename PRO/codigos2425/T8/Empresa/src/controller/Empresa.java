package controller;

import model.Persona;
import model.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class Empresa<V> {

    private List<V> listaPersonas;

    private Departamento departamento;

    public Empresa() {
        listaPersonas = new ArrayList<>();
    }

    public void construidDepartamento(){
        this.departamento = this.new Departamento();
        departamento.

    }

    public void contratarPersona(V persona){
        listaPersonas.add(persona);
    }

    public void mostrarSueldos(){
        for (V p: listaPersonas) {
            if(p instanceof Trabajador){
                ((Trabajador) p).calcularSueldo();
            }
        }
    }

    class Departamento{

        private String nombre;
        public Departamento(){

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}
