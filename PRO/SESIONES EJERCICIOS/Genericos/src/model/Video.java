package model;

public final class Video extends Elemento{

    private Persona director;
    private Persona[] actores;

    public Video() {
    }

    public Video(int id, String titulo, Persona autor, int tamanio, String formato, Persona director, Persona[] actores) {
        super(id, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = actores;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        director.mostrarDatos();
        for ( Persona actor: actores ){
            actor.mostrarDatos();
        }
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public Persona[] getActores() {
        return actores;
    }

    public void setActores(Persona[] actores) {
        this.actores = actores;
    }
}
