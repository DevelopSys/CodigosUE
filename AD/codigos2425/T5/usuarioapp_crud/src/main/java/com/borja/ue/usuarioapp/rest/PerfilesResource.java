package com.borja.ue.usuarioapp.rest;

import com.borja.ue.usuarioapp.model.PerfilesDTO;
import com.borja.ue.usuarioapp.service.PerfilesService;
import com.borja.ue.usuarioapp.util.ReferencedException;
import com.borja.ue.usuarioapp.util.ReferencedWarning;
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
@RequestMapping(value = "/api/perfiless", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerfilesResource {

    private final PerfilesService perfilesService;

    public PerfilesResource(final PerfilesService perfilesService) {
        this.perfilesService = perfilesService;
    }

    @GetMapping
    public ResponseEntity<List<PerfilesDTO>> getAllPerfiless() {
        return ResponseEntity.ok(perfilesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilesDTO> getPerfiles(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(perfilesService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPerfiles(@RequestBody @Valid final PerfilesDTO perfilesDTO) {
        final Long createdId = perfilesService.create(perfilesDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePerfiles(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PerfilesDTO perfilesDTO) {
        perfilesService.update(id, perfilesDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfiles(@PathVariable(name = "id") final Long id) {
        final ReferencedWarning referencedWarning = perfilesService.getReferencedWarning(id);
        if (referencedWarning != null) {
            throw new ReferencedException(referencedWarning);
        }
        perfilesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
