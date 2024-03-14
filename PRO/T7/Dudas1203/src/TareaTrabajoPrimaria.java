public final class TareaTrabajoPrimaria extends TareaTrabajo{

    private int rendimiento;

    public TareaTrabajoPrimaria(String titulo, String depscripcion, boolean completada, int presupuesto, int rendimiento) {
        super(titulo, depscripcion, completada, presupuesto);
        this.rendimiento = rendimiento;
    }

    public TareaTrabajoPrimaria() {
    }

    public void metodoTareaPrimaria(){
        System.out.println("Ejecutado desde primaria");
    }
}
