package io.bootify.my_app.rest;

import io.bootify.my_app.model.ProductosDTO;
import io.bootify.my_app.service.ProductosService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping(value = "/api/productoss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductosResource {

    private final ProductosService productosService;

    public ProductosResource(final ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public ResponseEntity<List<ProductosDTO>> getAllProductoss() {
        return ResponseEntity.ok(productosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosDTO> getProductos(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(productosService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createProductos(
            @RequestBody @Valid final ProductosDTO productosDTO) {
        final Long createdId = productosService.create(productosDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateProductos(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ProductosDTO productosDTO) {
        productosService.update(id, productosDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteProductos(@PathVariable(name = "id") final Long id) {
        productosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
