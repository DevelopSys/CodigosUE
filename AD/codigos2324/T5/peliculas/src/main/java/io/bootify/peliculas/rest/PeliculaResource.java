package io.bootify.peliculas.rest;

import io.bootify.peliculas.model.PeliculaDTO;
import io.bootify.peliculas.service.PeliculaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeliculaResource {

    private final PeliculaService peliculaService;

    public PeliculaResource(final PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAllPeliculas() {
        return ResponseEntity.ok(peliculaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getPelicula(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(peliculaService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPelicula(@RequestBody @Valid final PeliculaDTO peliculaDTO) {
        final Long createdId = peliculaService.create(peliculaDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePelicula(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PeliculaDTO peliculaDTO) {
        peliculaService.update(id, peliculaDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable(name = "id") final Long id) {
        peliculaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
