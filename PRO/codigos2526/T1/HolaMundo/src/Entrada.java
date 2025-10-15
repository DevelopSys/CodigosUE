// este comentario es para aclararme como funciona las clase
public class Entrada {

    public static void main(String[] args){
        System.out.println("Hola Mundo");
        miMetodo();
        otroMetodo();
    }

    /*
    Este comentario es para ver como funciona el metodo en concreto
    Puedo escribir tantas lineas como quiera
    NO ES PARA ESCRIBIR EL QUIJOTE
     */
    public static void otroMetodo(){
        System.out.println("Esta impresion es llamada desde el metodo 1");
    }

    /**
     * Documentacion
     */
    public static void miMetodo(){
        System.out.println("Este mensaje es desde otro metodo");
    }
}