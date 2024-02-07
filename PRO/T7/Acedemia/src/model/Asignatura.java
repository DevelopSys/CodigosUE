package model;

public class Asignatura {

    private int id;
    private double calificacion;

    public Asignatura(){}
    public Asignatura(int id){
        this.id = id;
        // calificacion = 0.0
    }

    public void mostrarDatos(){
        System.out.println("ID: "+id);
        System.out.println("Calificacion: "+calificacion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
