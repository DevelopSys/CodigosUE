package com.example.tienda_ue.controller;

import com.example.tienda_ue.model.Cliente;
import com.example.tienda_ue.service.ClienteService;
import com.example.tienda_ue.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    // https://localhost:8080/api/clientes/getById/1
    @GetMapping("getById/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Cliente> clienteOptional = clienteService.getById(id);
            if (clienteOptional.isPresent()) {
                response.put("code", 1);
                response.put("message", "Usuario obtenido con exito");
                response.put("data", clienteOptional.get());
            } else {
                response.put("code", 2);
                response.put("message", "id indicada invalida");
                response.put("data", null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }


    @GetMapping("getAll")
    public ResponseEntity<?> getClientes() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Cliente> clientes = clienteService.getAllClientes();

            response.put("code", 1);
            response.put("message", "Usuarios obtenido con exito");
            response.put("data", clientes);
            response.put("size", clientes.size());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> addCliente(@RequestBody Cliente cliente) {
        try {

            Cliente clienteAnadido = clienteService.addUser(cliente);
            Map<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("message", "Usuarios anadido con exito");
            response.put("data", clienteAnadido);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DataIntegrityViolationException e) {

            Map<String, Object> response = new HashMap<>();
            response.put("code", 3);
            response.put("message", "Clave duplicada");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable int id, @RequestParam String nombre, @RequestParam int telefono) {
        // obtener el usuario con id -> mirar si existe
            // cambio caracteristicas -> set
            // voy al servicio y lo guardo
        // TODO nos quedamos aqui
        return null;
    }


}
