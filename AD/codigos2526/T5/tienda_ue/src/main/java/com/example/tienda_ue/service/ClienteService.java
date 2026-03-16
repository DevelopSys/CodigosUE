package com.example.tienda_ue.service;

import com.example.tienda_ue.model.Cliente;
import com.example.tienda_ue.model.Producto;
import com.example.tienda_ue.repository.ClienteRepository;
import com.example.tienda_ue.repository.ProductoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;

    // obtener todos los clientes
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    // obtener todos los datos de un cliente -> id
    public Optional<Cliente> getById(long id){
        return clienteRepository.findById(id);
    }

    // anadir un cliente
    public Cliente addUser(Cliente cliente){
        // añadirle la logiga de la base de datos
            // no se puede añadir si ya existe
            // obten el cliente con un correo
            // TODO -> ojo con el fallo del unique
        return clienteRepository.save(cliente);
    }

    // borrar un cliente
    public boolean deleteCliente(Long id){

        // la logica de este usuario no existe con este id
        if (getById(id).isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // actualizar Usuario
    public Cliente updateCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // anadir un producto al cliente -> comprar
    public void anadirProducto(long idCliente, long idProducto){
        // busco el cliente
        Optional<Cliente> cliente = getById(idCliente);
        // busco el producto
        Optional<Producto> producto = productoRepository.findById(idProducto);
        if (cliente.isPresent() && producto.isPresent()) {

        } else {

        }
        // anado en la lista de productos del cliente el producto encontrado
    }
}
