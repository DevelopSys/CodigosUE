package io.bootify.peliculas.rest;

import io.bootify.peliculas.model.DirectorDTO;
import io.bootify.peliculas.service.DirectorService;
import io.bootify.peliculas.util.ReferencedException;
import io.bootify.peliculas.util.ReferencedWarning;
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
@RequestMapping(value = "/api/directors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DirectorResource {

    private final DirectorService directorService;

    public DirectorResource(final DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<DirectorDTO>> getAllDirectors() {
        return ResponseEntity.ok(directorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDTO> getDirector(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(directorService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createDirector(@RequestBody @Valid final DirectorDTO directorDTO) {
        final Long createdId = directorService.create(directorDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateDirector(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final DirectorDTO directorDTO) {
        directorService.update(id, directorDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable(name = "id") final Long id) {
        final ReferencedWarning referencedWarning = directorService.getReferencedWarning(id);
        if (referencedWarning != null) {
            throw new ReferencedException(referencedWarning);
        }
        directorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
