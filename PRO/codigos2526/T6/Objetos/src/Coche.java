public class Coche {
    private String marca, modelo, color, combustible;
    private char etiqueta;
    private int cv;
    private double precio;

    // constructores -> minimo un constructor -> por defecto el contructor que existe
    // es el por vacio -> si escribo un constructor el vacio desaparece (se enmascara)
    // public Coche(){ cuerpo }
    public Coche() {
    }

    public Coche(String marca, String modelo, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    public Coche(String marca, String modelo, int cv, int precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.precio = precio;
    }

    public void acelerar() {
        System.out.println("El coche está acelerando");
    }

    public void frenar() {
        System.out.println("El coche esta frenando");
    }

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

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public char getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(char etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
