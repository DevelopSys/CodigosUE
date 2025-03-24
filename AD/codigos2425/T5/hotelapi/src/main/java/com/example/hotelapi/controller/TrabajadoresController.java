package com.example.hotelapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadoresController {

        @GetMapping("/all")
        public String getAllTrabajadores(){
                return "Trabajadores llamados correctamente";
        }
}
