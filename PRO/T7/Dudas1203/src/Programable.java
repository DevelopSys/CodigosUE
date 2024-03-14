public interface Programable {

    // conjunto de metodos abs o constantes
    // public final int IVA = 21;
    void programar();
    default void metodoDefecto(){
        System.out.println("este metodo lo tienen todas las clases que me han implementado");
    }
}
