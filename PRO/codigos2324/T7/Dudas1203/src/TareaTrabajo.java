public abstract class TareaTrabajo extends Tarea{

    private int presupuesto;

    public TareaTrabajo() {
    }

    public TareaTrabajo(String titulo, String depscripcion, boolean completada, int presupuesto) {
        super(titulo, depscripcion, completada);
        this.presupuesto = presupuesto;
    }

    public void metodoTareaTrabajo(){
        System.out.println("Ejecutado desde tarea trabajo");
    }
}
