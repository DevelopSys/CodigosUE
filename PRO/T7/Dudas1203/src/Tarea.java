public abstract class Tarea {

    private String titulo, depscripcion;
    private boolean completada;


    public Tarea() {
    }

    public Tarea(String titulo, String depscripcion, boolean completada) {
        this.titulo = titulo;
        this.depscripcion = depscripcion;
        this.completada = completada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDepscripcion() {
        return depscripcion;
    }

    public void setDepscripcion(String depscripcion) {
        this.depscripcion = depscripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
