package model;

public class Video extends Elemento{

    private String director;
    private String[] actores;


    public Video() {
    }


    public Video(int id, String titulo, String autor, String formato,
                 int tamanio, String directo, String[] actores){
        super(id, titulo, autor, formato, tamanio);
        this.director = directo;
        this.actores = actores;
    }

    public void metodoVideo(){
        System.out.println("Este es un metodo que solo lo tiene video");
    }
    @Override
    public void validar() {
        if (actores.length>1){
            System.out.println("El video queda validado");
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("director = " + director);
        System.out.println("actores = " + actores);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }
}
