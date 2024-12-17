package com.example.concesionario.dataset

import com.example.concesionario.model.Marca

class DataSet {
    // lista static
    companion object {
        val lista: ArrayList<Marca> = arrayListOf(
            Marca(
                "Mercedes",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Mercedes-Benz_Star_2022.svg/800px-Mercedes-Benz_Star_2022.svg.png"
            ),
            Marca(
                "BMW",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/2048px-BMW.svg.png"
            ),
            Marca(
                "Audi",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Audi_logo_detail.svg/1426px-Audi_logo_detail.svg.png"
            ),
            Marca(
                "Ford",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Ford_logo_flat.svg/2560px-Ford_logo_flat.svg.png"
            ),
            Marca(
                "Skoda",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2560px-cosa.svg.jpg"
            ),
        )
        fun agregarDatos(marca: Marca){
            this.lista.add(marca)
        }
    }
}