package io.bootify.my_app.service;

import io.bootify.my_app.domain.Productos;
import io.bootify.my_app.events.BeforeDeleteProductos;
import io.bootify.my_app.model.ProductosDTO;
import io.bootify.my_app.repos.ProductosRepository;
import io.bootify.my_app.util.CustomCollectors;
import io.bootify.my_app.util.NotFoundException;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class ProductosService {

    private final ProductosRepository productosRepository;
    private final ApplicationEventPublisher publisher;

    public ProductosService(final ProductosRepository productosRepository,
            final ApplicationEventPublisher publisher) {
        this.productosRepository = productosRepository;
        this.publisher = publisher;
    }

    public List<ProductosDTO> findAll() {
        final List<Productos> productoses = productosRepository.findAll(Sort.by("id"));
        return productoses.stream()
                .map(productos -> mapToDTO(productos, new ProductosDTO()))
                .toList();
    }

    public ProductosDTO get(final Long id) {
        return productosRepository.findById(id)
                .map(productos -> mapToDTO(productos, new ProductosDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ProductosDTO productosDTO) {
        final Productos productos = new Productos();
        mapToEntity(productosDTO, productos);
        return productosRepository.save(productos).getId();
    }

    public void update(final Long id, final ProductosDTO productosDTO) {
        final Productos productos = productosRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(productosDTO, productos);
        productosRepository.save(productos);
    }

    public void delete(final Long id) {
        final Productos productos = productosRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        publisher.publishEvent(new BeforeDeleteProductos(id));
        productosRepository.delete(productos);
    }

    private ProductosDTO mapToDTO(final Productos productos, final ProductosDTO productosDTO) {
        productosDTO.setId(productos.getId());
        productosDTO.setNombre(productos.getNombre());
        productosDTO.setPrecio(productos.getPrecio());
        return productosDTO;
    }

    private Productos mapToEntity(final ProductosDTO productosDTO, final Productos productos) {
        productos.setNombre(productosDTO.getNombre());
        productos.setPrecio(productosDTO.getPrecio());
        return productos;
    }

    public Map<Long, Long> getProductosValues() {
        return productosRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(Productos::getId, Productos::getId));
    }

}
