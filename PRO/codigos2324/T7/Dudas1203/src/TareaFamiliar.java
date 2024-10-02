public final class TareaFamiliar extends Tarea implements Programable{

    private String localizacion;

    public TareaFamiliar() {

    }

    public TareaFamiliar(String titulo, String depscripcion, boolean completada, String localizacion) {
        super(titulo, depscripcion, completada);
        this.localizacion = localizacion;
    }

    @Override
    public void programar() {
        System.out.println("Vas a programar una tarea familiar");
    }
}
