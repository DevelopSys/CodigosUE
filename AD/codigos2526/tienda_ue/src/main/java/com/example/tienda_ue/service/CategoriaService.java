package com.example.tienda_ue.service;

import com.example.tienda_ue.model.Categoria;
import com.example.tienda_ue.model.Producto;
import com.example.tienda_ue.repository.CategoriaRepository;
import com.example.tienda_ue.repository.ProductoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {

    // la logica para poder decir sobre las ejecuciones en la bd
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }
    public Optional<Categoria> getById(Long id){
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> getByName(String name){
        return categoriaRepository.findByNombre(name);
    }

}
