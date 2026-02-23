package io.bootify.my_app.service;

import io.bootify.my_app.domain.Cliente;
import io.bootify.my_app.domain.Productos;
import io.bootify.my_app.events.BeforeDeleteProductos;
import io.bootify.my_app.model.ClienteDTO;
import io.bootify.my_app.repos.ClienteRepository;
import io.bootify.my_app.repos.ProductosRepository;
import io.bootify.my_app.util.NotFoundException;
import java.util.HashSet;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ProductosRepository productosRepository;

    public ClienteService(final ClienteRepository clienteRepository,
            final ProductosRepository productosRepository) {
        this.clienteRepository = clienteRepository;
        this.productosRepository = productosRepository;
    }

    public List<ClienteDTO> findAll() {
        final List<Cliente> clientes = clienteRepository.findAll(Sort.by("id"));
        return clientes.stream()
                .map(cliente -> mapToDTO(cliente, new ClienteDTO()))
                .toList();
    }

    public ClienteDTO get(final Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> mapToDTO(cliente, new ClienteDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ClienteDTO clienteDTO) {
        final Cliente cliente = new Cliente();
        mapToEntity(clienteDTO, cliente);
        return clienteRepository.save(cliente).getId();
    }

    public void update(final Long id, final ClienteDTO clienteDTO) {
        final Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(clienteDTO, cliente);
        clienteRepository.save(cliente);
    }

    public void delete(final Long id) {
        final Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        clienteRepository.delete(cliente);
    }

    private ClienteDTO mapToDTO(final Cliente cliente, final ClienteDTO clienteDTO) {
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setProductos(cliente.getProductos().stream()
                .map(productos -> productos.getId())
                .toList());
        return clienteDTO;
    }

    private Cliente mapToEntity(final ClienteDTO clienteDTO, final Cliente cliente) {
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setTelefono(clienteDTO.getTelefono());
        final List<Productos> productos = productosRepository.findAllById(
                clienteDTO.getProductos() == null ? List.of() : clienteDTO.getProductos());
        if (productos.size() != (clienteDTO.getProductos() == null ? 0 : clienteDTO.getProductos().size())) {
            throw new NotFoundException("one of productos not found");
        }
        cliente.setProductos(new HashSet<>(productos));
        return cliente;
    }

    public boolean correoExists(final String correo) {
        return clienteRepository.existsByCorreoIgnoreCase(correo);
    }

    @EventListener(BeforeDeleteProductos.class)
    public void on(final BeforeDeleteProductos event) {
        // remove many-to-many relations at owning side
        clienteRepository.findAllByProductosId(event.getId()).forEach(cliente ->
                cliente.getProductos().removeIf(productos -> productos.getId().equals(event.getId())));
    }

}
