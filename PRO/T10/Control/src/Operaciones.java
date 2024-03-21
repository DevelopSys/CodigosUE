public class Operaciones {

    public void accesoElemento() {
        String dato = null;
        String[] datos = new String[]{"hola", "esto", "es", "un", "array"};
        try {
            System.out.println(datos[3]);
            System.out.println("La longitud del dato es " + dato.length());
        } catch (NullPointerException e) {
            System.out.println("Capturando null");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Capturando array index");
        } catch (Exception e) {
            System.out.println("Capturando el resto de errores");
        }
        System.out.println("Terminando la ejecucion del metodo accesoElemento");
    }

    public void accesoElementoDelegado()
            throws NullPointerException, ArrayIndexOutOfBoundsException
            , Exception {


        int numeroEx = 10;
        if (numeroEx>0){
            // saltar un error
            throw new Exception("Error que me saco de la manga");
        }
        String dato = null;
        int numero = Integer.parseInt("Hola");
        String[] datos = new String[]{"hola", "esto", "es", "un", "array"};
        System.out.println(datos[10]);
        System.out.println("La longitud del dato es " + dato.length());
        System.out.println("Terminando la ejecucion del metodo accesoElemento");
    }
}
