public class Entrada {

    public static void main(String[] args) {

        Operaciones operaciones = new Operaciones();
        System.out.println("Empezando la prueba");
        try {
        operaciones.accesoElementoDelegado();
        } catch (NullPointerException e){
            System.out.println("Nulo");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("array");
        } catch (Exception e){
            System.out.println("Todos");
        } finally {
            System.out.println("Ejecuta siempre");
        }
        System.out.println("Terminando el main");

    }
}
