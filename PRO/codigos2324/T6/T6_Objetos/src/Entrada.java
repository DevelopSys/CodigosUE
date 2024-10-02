import model.Aula;
import model.Usuario;

public class Entrada {
    public static void main(String[] args) {
        // instanciando un objeto
        Usuario usuarioDudad = new Usuario();
        usuarioDudad.setPass("");
        usuarioDudad.setCorreo("");
        usuarioDudad.setDni("");
        Usuario usuario0 = new Usuario("borja","martin",123);
        Usuario usuario1 = new Usuario("Borja", "Martin", "1234A");
        // nombre=Borja, apellido=Martin, dni=1234A, pass=null, telefono=0, nacionalidad=null
        Usuario usuario2 = new Usuario("Luis", "Herrera", "2345");
        // nombre=Luis, apellido=Herrera, dni=2345, pass=null, telefono=0, nacionalidad=null
        Usuario usuario3 = new Usuario("Celia", "Martin", "3456B",
                "celia@gmail.com", 12345);
        usuario3.setPass("password1234");
        // nombre=Celia, apellido=Martin, dni=3456B, pass=null, telefono=12345, nacionalidad=null, correo = celia@gmail.com
        Usuario usuario4 = new Usuario("Claudia","claudia@gmail.com");


        Aula aula = new Aula(usuario2,usuario3);
        aula.setUsuario1(usuario4);
        aula.mostrarDatosUsuarios();
        // imprimir su nombre
        //System.out.println(usuario4.getNombre());
        //usuario4.setNombre("Julia");
        //System.out.println(usuario4.getNombre());
        //usuario4.saludar("Hola chicos, espero que nos enteremos de poo");
        //usuario2.saludar("Este tipo de programacion es el que se utiliza en el ambiente profesional");
        //usuario4.mostrarDatos();
        //usuario3.mostrarDatos();

    }
}
