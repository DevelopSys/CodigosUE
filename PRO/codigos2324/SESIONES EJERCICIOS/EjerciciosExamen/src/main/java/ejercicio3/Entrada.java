package ejercicio3;

public class Entrada {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.darAltaUsuario(new Usuario("Borja1","correo1","123"));
        sistema.darAltaUsuario(new Usuario("Borja2","correo2","234"));
        sistema.darAltaUsuario(new Usuario("Borja3","correo3","345"));

        for ( Usuario item : sistema.getListaUsuarios()) {
            item.mostrarDatos();
        }

        if (sistema.loginUsuario("correo1","123") != null){
            System.out.println("Login correcto");
        } else {
            System.out.println("Login incorrecto");
        }
    }
}
