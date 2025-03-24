package com.borja.ue.usuarioapp.rest;

import com.borja.ue.usuarioapp.domain.Perfiles;
import com.borja.ue.usuarioapp.model.EmpleadosDTO;
import com.borja.ue.usuarioapp.repos.PerfilesRepository;
import com.borja.ue.usuarioapp.service.EmpleadosService;
import com.borja.ue.usuarioapp.util.CustomCollectors;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort;
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
@RequestMapping(value = "/api/empleadoss", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadosResource {

    private final EmpleadosService empleadosService;
    private final PerfilesRepository perfilesRepository;

    public EmpleadosResource(final EmpleadosService empleadosService,
            final PerfilesRepository perfilesRepository) {
        this.empleadosService = empleadosService;
        this.perfilesRepository = perfilesRepository;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadosDTO>> getAllEmpleadoss() {
        return ResponseEntity.ok(empleadosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosDTO> getEmpleados(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(empleadosService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createEmpleados(
            @RequestBody @Valid final EmpleadosDTO empleadosDTO) {
        final Long createdId = empleadosService.create(empleadosDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateEmpleados(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final EmpleadosDTO empleadosDTO) {
        empleadosService.update(id, empleadosDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleados(@PathVariable(name = "id") final Long id) {
        empleadosService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/idPerfilValues")
    public ResponseEntity<Map<Long, Long>> getIdPerfilValues() {
        return ResponseEntity.ok(perfilesRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(Perfiles::getId, Perfiles::getId)));
    }

}
