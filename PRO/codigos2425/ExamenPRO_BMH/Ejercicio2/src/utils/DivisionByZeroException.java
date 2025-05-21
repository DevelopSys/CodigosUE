package utils;

public class DivisionByZeroException extends Exception{
    // cuantos constructores tengo aqui -> 1

    public DivisionByZeroException() {
    }

    public DivisionByZeroException(String message) {
        super(message);
        // logica de lo que pasa cuando se crea la exception
    }
}
