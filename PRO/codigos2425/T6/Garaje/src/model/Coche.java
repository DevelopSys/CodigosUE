package model;

// estructura de lo que mas adelante sera un coche
public class Coche {

    // variables: aquello que cualifica al objeto
    // cuantos pongo? -> los que necesite
    private String marca, modelo, color, matricula;
    private Motor motor;
    private double precio;


    // metodos: aquellas funcionalidades que tendrá el objeto
    /* SOBRECARGA
    private int nombreMetodo(int cv, String nombre){
        return cv
    }

    private int nombreMetodo(int cv){
        return cv
    }
     */
    /* LOS CONSTRUCTORES

     */
    // metodos "constructores"
        // aquel que me permite darle forma (hacer realidad) un objeto
        // tengo tanto constructores como yo necesite
        // cuando no hay escrito ningun constructor -> implicito por defecto - vacio
        // si escribo un constructor -> vacio desaparece -> lo tienes que escribir explicitamente
        // siempre!!!!!! escribo el vacio

    public Coche(){
        this.motor = new Motor();
        // cv = 0
        // cc = 0
    }
    public Coche(String marca, String modelo, Motor motor){
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }
    public Coche(String marca, String modelo, Motor motor, double precio){
        this.modelo = modelo;
        this.precio = precio;
        this.motor = motor;
        this.marca = marca;
    }
    /*
    public Coche(String modelo, String marca, int cv, double precio){
        this.modelo = modelo;
        this.precio = precio;
        this.cv = cv;
        this.marca = marca;
    }
     */

    // metodos "normales"
        // aquellos que el programador crea porque el objeto quiero que tenga
        // esa funcionalidad

    public void mostrarDatos(){
        System.out.println("marca = " + marca);
        System.out.println("modelo = " + modelo);
        System.out.println("color = " + color);
        System.out.println("matricula = " + matricula);
        System.out.println("CV = " + motor.getCv());
        System.out.println("CC = " + motor.getCc());
        System.out.println("precio = " + precio);
    }
    // metodos "especiales"
        // aquellos que ya estan creados @override o que me dan acceso a las variables
        // getter setter toString
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
