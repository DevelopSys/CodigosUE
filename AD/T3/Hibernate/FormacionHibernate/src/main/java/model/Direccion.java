package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Embeddable
@Entity
public class Direccion {
    @Column
    private String calle;
    @Column
    private String provincia;
    @Column
    private String poblacion;
    @Column
    private int numero;

    public Direccion() {
    }

    public Direccion(String calle, String provincia, String poblacion, int numero) {
        this.calle = calle;
        this.provincia = provincia;
        this.poblacion = poblacion;
        this.numero = numero;
    }

    public void mostrarDatos(){
        System.out.println("Calle "+calle);
        System.out.println("Provincia "+provincia);
        System.out.println("Poblacion "+poblacion);
        System.out.println("Numero "+numero);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", provincia='" + provincia + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", numero=" + numero +
                '}';
    }
}
