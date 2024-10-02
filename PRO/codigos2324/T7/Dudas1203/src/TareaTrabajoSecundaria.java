import lombok.AllArgsConstructor;


public  final class TareaTrabajoSecundaria extends TareaTrabajo implements Programable{

    private boolean fechaLimite;


    public TareaTrabajoSecundaria() {
    }

    public TareaTrabajoSecundaria(String titulo, String depscripcion, boolean completada, int presupuesto, boolean fechaLimite) {
        super(titulo, depscripcion, completada, presupuesto);
        this.fechaLimite = fechaLimite;
    }

    public void metodoTareaSecundaria(){
        System.out.println("Ejecutado desde secundaria");
    }

    @Override
    public void programar() {
        System.out.println("Vas a programar una tarea de trabajo");
        System.out.println("Ten cuidadp que esto es muy importante");
    }
}
