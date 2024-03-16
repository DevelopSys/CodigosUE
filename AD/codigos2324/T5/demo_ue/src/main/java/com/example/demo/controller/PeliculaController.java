package com.example.demo.controller;


import com.example.demo.model.Director;
import com.example.demo.model.Pelicula;
import com.example.demo.services.DirectorService;
import com.example.demo.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/pelicula")
    public ResponseEntity<List<Pelicula>> getPelicula(Model model) {
        List<Pelicula> peliculas = peliculaService.findAllPelicula();
        if (peliculas == null || peliculas.isEmpty()) {
            model.addAttribute("peliculas",peliculas);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    @GetMapping(value = "/pelicula/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.findPeliculaById(id);
        if (pelicula.isPresent()) {
            return new ResponseEntity<>(pelicula.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/pelicula/anyo/{anyo}")
    public ResponseEntity<List<Pelicula>> getPeliculaByYear(@PathVariable Integer anyo) {
        List<Pelicula> peliculas = peliculaService.findPeliculaByAnyo(anyo);
        if (peliculas != null && peliculas.size() > 0) {
            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Inserta una película con el director asociado
    @PostMapping(value = "/director/{idDirector}/pelicula")
    public ResponseEntity<Pelicula> createPelicula(@PathVariable(value = "idDirector") Long idDirector,
                                                   @RequestBody Pelicula peliculaRequest) {
        // obtenemos el director
        Optional<Director> dire = directorService.findDirectorById(idDirector);
        if (dire.isPresent()) {
            Pelicula nuevaPelicula = new Pelicula();
            nuevaPelicula.setTitulo(peliculaRequest.getTitulo());
            nuevaPelicula.setAnyo(peliculaRequest.getAnyo());
            nuevaPelicula.setDirector(dire.get());

            System.out.println(nuevaPelicula);

            return new ResponseEntity<>(peliculaService.savePelicula(nuevaPelicula), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);


    }

    // https://127.1.1.1:8090/director --> {nombre:"directo",anio:123}
    @PutMapping(value = "/pelicula")
    public ResponseEntity<Pelicula> updatePelicula(@RequestBody Pelicula peliculaRequest) {

        Pelicula updated = peliculaService.updatePelicula(peliculaRequest);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @DeleteMapping(value = "/pelicula/{id}")
    public ResponseEntity<String> deletePelicula(@PathVariable Long id) {
        if (peliculaService.deletePelicula(id)) {
            return new ResponseEntity<String>("Eliminado correctamente", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Pelicula no encontrada", HttpStatus.NOT_FOUND);

    }

}
