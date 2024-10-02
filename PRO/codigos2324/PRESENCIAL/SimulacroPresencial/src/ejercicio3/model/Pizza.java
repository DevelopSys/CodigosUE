package ejercicio3.model;

import java.util.ArrayList;

public class Pizza {

    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    private int precio;

    public Pizza() {
    }

    public Pizza(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList();
    }

    public void agregarIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
        this.precio+= ingrediente.getPrecio();
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("precio = " + precio);
        System.out.println("Ingredientes: ");
        for (Ingrediente item: ingredientes) {
            System.out.println(item.getNombre() + " "+item.getPrecio());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
