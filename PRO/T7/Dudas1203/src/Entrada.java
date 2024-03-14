import utlis.Prioridad;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Prioridad[] prioridadres = new Prioridad[]{Prioridad.baja,Prioridad.media,Prioridad.alta};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica que prioridad quieres:\n1. Baja\n2. Media\n3. Alta");
        int prioradad = scanner.nextInt();
        Prioridad prioridad = prioridadres[0];

        Planificador planificador = new Planificador(1,"asdasd",false);
        System.out.println(planificador.getNombre());
        //Tarea tarea = new Tarea();
        //TareaTrabajo tareaTrabajo = new TareaTrabajo("nombre", "descripcion", false, 100);
        TareaTrabajoPrimaria tareaTrabajoPrimaria = new TareaTrabajoPrimaria("nombre", "descripcion",
                false, 100, 1000);
        TareaTrabajoSecundaria tareaTrabajoSecundaria = new TareaTrabajoSecundaria("nombre", "descripcion",
                false, 100, true);
        TareaFamiliar tareaFamiliar = new TareaFamiliar("nombre", "descripcion", false,
                "pozuelo");

        //System.out.println(Programable.IVA);

        ArrayList<Tarea> list = new ArrayList<>();
        list.add(tareaTrabajoPrimaria);
        list.add(tareaTrabajoSecundaria);
        list.add(tareaFamiliar);

        for (Tarea tarea : list) {

            if (tarea instanceof TareaTrabajo) {
                ((TareaTrabajo) tarea).metodoTareaTrabajo();
            }

            if (tarea instanceof TareaTrabajoPrimaria) {
                ((TareaTrabajoPrimaria) tarea).metodoTareaPrimaria();
            } else if (tarea instanceof TareaTrabajoSecundaria) {
                ((TareaTrabajoSecundaria) tarea).metodoTareaSecundaria();
            }

            if (tarea instanceof Programable) {
                ((Programable) tarea).programar();
                ((Programable) tarea).metodoDefecto();

            }

        }


    }
}
