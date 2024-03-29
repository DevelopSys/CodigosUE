package com.example.demo.controller;


import com.example.demo.model.Director;
import com.example.demo.model.Pelicula;
import com.example.demo.services.DirectorService;
import com.example.demo.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private PeliculaService peliculaService;


    @GetMapping(value = "/director")
    public List<Director> getDirector() {
        return directorService.findAllDirector();
    }

    @GetMapping(value = "/directorAnyo")
    public List<Director> getDirectorByYear(@RequestParam("anyo") int year) {
        return directorService.findDirectorByYear(year);
    }


    @GetMapping(value = "/director/{id}")
    public Optional<Director> getDirectorById(@PathVariable Long id) {
        return directorService.findDirectorById(id);
    }

    @GetMapping(value = "/directorEntre")
    public List<Director> getDirectorBetween(
            @RequestParam(name = "min", required = false) Integer min,
            @RequestParam(name = "max", required = false) Integer max) {
        return directorService.findByYearBetween(min, max);
    }

    @PostMapping(value = "/director")
    public Director addDirector(@RequestBody Director director) {
        return directorService.saveDirector(director);
    }

    @DeleteMapping(value = "/director/delete/{id}")
    public String deleteDirector(@PathVariable Long id) {
        return directorService.deleteDirector(id);
    }

    @PutMapping(value = "/director")
    public Director updateDirector(@RequestBody Director director) {
        return directorService.updateDirector(director);
    }

    @GetMapping(value = "/directorOld")
    public List<Director> getDirectorOld() {
        return directorService.findOldDirector();
    }

    @GetMapping(value = "/director/{idDirector}/pelicula")
    public List<Pelicula> getAllPeliculaByDirectorId(@PathVariable(value = "idDirector") Long idDirector) {
        return peliculaService.findPeliculaByDirectorId(idDirector);
    }

}
