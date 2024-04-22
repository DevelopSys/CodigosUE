import java.awt.*;

public class Biblioteca {

    String nombreBiblioteca;
    Catalogo catalogo;

    public Biblioteca(){
        //catalogo.mostrarMensajeCatalogo();
    }

    public void soltarMensajeBiblioteca() throws Exception{
        catalogo.mostrarMensajeCatalogo();
        // tratar yo la excepcion

        int numero  = Integer.valueOf("fgdwfv");
        System.out.println("Continuo con la ejecucion del metodo");

    }

    class Catalogo{

        Catalogo(){
            catalogo = Catalogo.this;
        }

        public void mostrarMensajeCatalogo(){
            System.out.println("mostrar mensaje");
            System.out.println(nombreBiblioteca);
        }

    }

}
