package model;

public final class Audio extends Elemento {


    private int duracion;
    private String soporte;

    public Audio() {
    }

    public Audio(int id, String titulo, Persona autor, int tamanio, String formato, int duracion, String soporte) {
        super(id, titulo, autor, tamanio, formato);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("duracion = " + duracion);
        System.out.println("soporte = " + soporte);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
