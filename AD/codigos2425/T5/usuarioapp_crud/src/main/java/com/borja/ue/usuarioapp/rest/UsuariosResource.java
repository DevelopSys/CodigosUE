package com.borja.ue.usuarioapp.rest;

import com.borja.ue.usuarioapp.model.UsuariosDTO;
import com.borja.ue.usuarioapp.service.UsuariosService;
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
@RequestMapping(value = "/api/usuarioss", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuariosResource {

    private final UsuariosService usuariosService;

    public UsuariosResource(final UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> getAllUsuarioss() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDTO> getUsuarios(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(usuariosService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createUsuarios(
            @RequestBody @Valid final UsuariosDTO usuariosDTO) {
        final Integer createdId = usuariosService.create(usuariosDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateUsuarios(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final UsuariosDTO usuariosDTO) {
        usuariosService.update(id, usuariosDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarios(@PathVariable(name = "id") final Integer id) {
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
