package controller;

// estamos creando un tipo de dato
public class Metodo {

    // modificador acceso: public -> todas las variables de tipo Metodo pueden ejecutar el metodo
    // modificador acceso: private -> solo se puede acceder al metodo desde la propia clase
    // modificador acceso: protected -> todas las variables de tipo Metodo pueden ejecutar el metodo,
    // pero que sean llamadas desde una clase del mismo paquete
    // retorno
    // retorno void -> no retorno nada, y solo ejecuto su contenido
    // retorno TIPO -> retorna el tipo que se le indique, ademas de ejecuto su contenido
    // si se le indica un retorno, la ultima linea del método es un return
    public void metodoSaludar() {
        System.out.println("Bienvendido a la ejecucion de los metodos");
    }

    // dos metodos se pueden llamar igual, siempre y cuando su firma sea diferente
    // sobrecarga de metodos: crear metodos con firmas diferentes pero con el mismo nombre
    public double realizarDivision(){
        return (double) 4/2;
    }
    // todo lo que yo ponga entre parentesis solo es una referencia
    // se le da valor cuando se llama el metodo
    public double realizarDivision(int operador1){
        return (double) 4/operador1;
    }
    public double realizarDivision(int operador1, int operador2){
        return (double) operador1/operador2;
    }
    public double realizarDivision(double operador2, int operador1){
        return (double) operador1/operador2;
    }
    public double realizarDivision(int operador1, double operador2){
        return (double) operador1/operador2;
    }
    public double realizarDivision(double operador2, int operador1, int numero2){
        return (double) operador1/operador2;
    }
    public double realizarDivision(double operador2, int operador1, int numero2, int numero3){
        return (double) operador1/operador2;
    }

    public void calcularMedia(int[] numeros){
        // 2 3 3 12 312 31 23 123 123
        double media = 0;
        int sumatorio = 0;
        for ( int item : numeros ){
            sumatorio+=item;
        }
        media = (double) sumatorio/numeros.length;
        System.out.println("La media calculada es "+media);

    }

    public void sacarDinero(int pin, int cantidad){
        int saldo = 100;
        if (pin == 1234){
            System.out.println("Pin correcto");
            if (cantidad>100){
                System.out.println("Saldo insuficiente");
            } else {
                System.out.println("sacando dinero");
            }
        } else {
            System.out.println("Pin incorrecto");
        }
        sacarDinero(pin,cantidad);
    }


    @Override
    public String toString() {
        return "Clase metodo";
    }
}
