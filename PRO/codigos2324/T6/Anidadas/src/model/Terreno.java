package model;

public class Terreno {

    private int metros;
    private Casa casa;


    public Terreno() {
    }

    public Terreno(int metros) {
        this.metros = metros;
    }

    public void construirCasa(){
        this.casa = new Casa(4, false);
    }

    public void realizarObras(){
        casa.constuirPiscina();
    }

    public void mostrarDatos(){

        // capturar datos da casa??
        casa.constuirPiscina();
        System.out.println("Mostrando datos del terreno");
        System.out.println("metros = " + metros);
        casa.mostrarDatos();
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    // clase interna, depende exclusivamente de la clase general


    class Casa {

        private int numeroHabitaciones;
        private boolean piscina;
        int metros;

        public Casa() {
        }

        public Casa(int numeroHabitaciones, boolean piscina) {
            this.numeroHabitaciones = numeroHabitaciones;
            this.piscina = piscina;
        }

        public void constuirPiscina(){
            // si el terreno es inferior a 100 no puedo construir la piscina
            if (Terreno.this.metros < 100){
                System.out.println("Construyendo una piscina");
                piscina = true;
            }

        }

        public void mostrarDatos(){
            System.out.println("Sacando datos de la casa");
            System.out.println("numeroHabitaciones = " + numeroHabitaciones);
            System.out.println("piscina = " + piscina);
        }

        public int getNumeroHabitaciones() {
            return numeroHabitaciones;
        }

        public void setNumeroHabitaciones(int numeroHabitaciones) {
            this.numeroHabitaciones = numeroHabitaciones;
        }

        public boolean isPiscina() {
            return piscina;
        }

        public void setPiscina(boolean piscina) {
            this.piscina = piscina;
        }
    }


}