package com.example.hotelapi.controller;

import com.example.hotelapi.model.Usuario;
import com.example.hotelapi.repository.UsuarioRepository;
import com.example.hotelapi.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    // crear tantos metodos como peticiones quiere resolver
    // obtener datos de conexion correcta
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll(){
        // quiero ejecutar -> todos los usuarios -> servicio
        return new ResponseEntity<>(usuariosService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/info")
    public String conexionCorrecta(){
        return "Conexion realizada correctamente";
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> agregarUsuarios(@RequestBody Usuario usuario){

        // comprueba si ya hay un usuario con ese mail
        Usuario usuario1 = usuariosService.getByEmail(usuario.getCorreo());
        if (usuario1 !=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<Usuario>(usuariosService.addUser(usuario), HttpStatus.OK);
        }

    }

    @GetMapping("/error")
    public String error(){
        return "Fallo en la consulta";
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> realizarLogin(@RequestParam String mail , @RequestBody String pass){
        return new ResponseEntity<>( usuariosService.getLogin(mail,pass) ,HttpStatus.OK);
    }

    @GetMapping("/mail")
    public ResponseEntity<Usuario> getUserByMail(@RequestParam String correo){
        Usuario usuario = usuariosService.getByEmail(correo);
        if (usuario!=null){
            return new ResponseEntity<>(usuariosService.getByEmail(correo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(usuariosService.getByEmail(correo), HttpStatus.NO_CONTENT);
        }
    }


    // http://localohost:8080/usuarios/detail/1
    @GetMapping("/detail/{id}")
    public ResponseEntity<Usuario> getUsuarioDetail(@PathVariable int id){
        Usuario usuario = usuariosService.getUsuarioDetail(id);
        if (usuario !=null){
            return new ResponseEntity<>(usuariosService.getUsuarioDetail(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }




}
