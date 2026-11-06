package model

import java.io.Serializable

class User(var name: String, var surname: String = "") : Cosa(), Serializable {
    // atributos
    var phone: Int? = null;
    // constructores -> vacio --- n
    /*
        public User(String name, String surname){
            this.name = name
            this.surname = surname
        }
     */
    // primario -> aquel que todo obj tiene que complir
    // secundarios -> aquellos que ademas de tener lo que dice el primario agrega cosas adicionals
    /*
    public NombreClase(){}
     */
    // funcionales
    // getter / setter -> implicitos
    constructor(name: String, surname: String,  phone: Int) : this(name,surname) {
       this.phone = phone
    }

    override fun metodoHerencia() {
        super.metodoHerencia()
    }

    fun showData() {
        println("name = ${name}")
        println("surname = ${surname}")
        println("phone = ${phone ?: 0}")
    }


}