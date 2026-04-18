package io.bootify.cursos_app.rest;

import io.bootify.cursos_app.model.ProfesorDTO;
import io.bootify.cursos_app.service.CursoService;
import io.bootify.cursos_app.service.ProfesorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
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
@RequestMapping(value = "/api/profesors", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfesorResource {

    private final ProfesorService profesorService;
    private final CursoService cursoService;

    public ProfesorResource(final ProfesorService profesorService,
            final CursoService cursoService) {
        this.profesorService = profesorService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> getAllProfesors() {
        return ResponseEntity.ok(profesorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> getProfesor(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(profesorService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createProfesor(@RequestBody @Valid final ProfesorDTO profesorDTO) {
        final Long createdId = profesorService.create(profesorDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateProfesor(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ProfesorDTO profesorDTO) {
        profesorService.update(id, profesorDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteProfesor(@PathVariable(name = "id") final Long id) {
        profesorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/idCursoFKValues")
    public ResponseEntity<Map<Long, String>> getIdCursoFKValues() {
        return ResponseEntity.ok(cursoService.getCursoValues());
    }

}
