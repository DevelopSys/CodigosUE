import model.Agenda;
import model.Usuario;

public class Entrada {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregarUsuario(new Usuario("1234A","Borja", "Martin1",1234));
        agenda.agregarUsuario(new Usuario("1234B","Jose", "Martin2",2345));
        agenda.agregarUsuario(new Usuario("1234C","Mario", "Martin3",3456));
        agenda.agregarUsuario(new Usuario("1234D","Alejandra", "Martin4",4567));

        agenda.eliminarUsuario("1234A");
        agenda.agregarUsuario(new Usuario("1234A","BorjaNuevo", "Martin1",1234));

        agenda.mostrarUsuarios();
    }

}
