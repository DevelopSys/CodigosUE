package model;

public class Trabajador {

    // atibutos -> elementos que cualifican. siempre privados
    private String nombre, apellido, dni;
    private int irpf, numeroPagas;
    private double salario;
    private boolean experiencia;

    // metodos -> constructor. minimo tenemos un constructor
    // -> El constructor vacio (solo esta disponible si no hay otro contructor)
    // public Trabajador()

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Trabajador(String nombre, String apellido, String dni, double salario, int numeroPagas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
        this.numeroPagas = numeroPagas;
        // irpf = 0
        // experiencia = false
    }

    public Trabajador(String nombre, String apellido, String dni, int irpf, int numeroPagas, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.irpf = irpf;
        this.numeroPagas = numeroPagas;
        this.salario = salario;
    }

    // metodos tipo_acceso tipo_retorno nombre_metodo -> creados por nosotros

    // metodos "especiales" -> getter public int getSueldo() -> permite acceder al valor de una variable / setter -> alterar el valor de la variable

    public void mostrarDatos() {
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
        System.out.println("irpf = " + irpf);
        System.out.println("numeroPagas = " + numeroPagas);
        System.out.println("salario = " + salario);
        System.out.println("experiencia = " + experiencia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIrpf() {
        return irpf;
    }

    public void setIrpf(int irpf) {
        this.irpf = irpf;
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }
}
