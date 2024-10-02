package model;

public enum Puesto {

    // DATOS FIJOS

    mando("este puesto manda sobre todo el mundo",1000)
    ,gerencia ("este puesto se encrga de controlar",5000)
    ,direccion ("este es el que controla la empresa",15000);

    private String descripcion;
    private int salarioAdicion;

    Puesto(String descripcion, int salarioAdicion) {
        this.descripcion = descripcion;
        this.salarioAdicion = salarioAdicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSalarioAdicion() {
        return salarioAdicion;
    }

    public void setSalarioAdicion(int salarioAdicion) {
        this.salarioAdicion = salarioAdicion;
    }
}
