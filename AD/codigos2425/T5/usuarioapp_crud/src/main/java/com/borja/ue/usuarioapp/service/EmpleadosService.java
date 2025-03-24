package com.borja.ue.usuarioapp.service;

import com.borja.ue.usuarioapp.domain.Empleados;
import com.borja.ue.usuarioapp.domain.Perfiles;
import com.borja.ue.usuarioapp.model.EmpleadosDTO;
import com.borja.ue.usuarioapp.repos.EmpleadosRepository;
import com.borja.ue.usuarioapp.repos.PerfilesRepository;
import com.borja.ue.usuarioapp.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;
    private final PerfilesRepository perfilesRepository;

    public EmpleadosService(final EmpleadosRepository empleadosRepository,
            final PerfilesRepository perfilesRepository) {
        this.empleadosRepository = empleadosRepository;
        this.perfilesRepository = perfilesRepository;
    }

    public List<EmpleadosDTO> findAll() {
        final List<Empleados> empleadoses = empleadosRepository.findAll(Sort.by("id"));
        return empleadoses.stream()
                .map(empleados -> mapToDTO(empleados, new EmpleadosDTO()))
                .toList();
    }

    public EmpleadosDTO get(final Long id) {
        return empleadosRepository.findById(id)
                .map(empleados -> mapToDTO(empleados, new EmpleadosDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final EmpleadosDTO empleadosDTO) {
        final Empleados empleados = new Empleados();
        mapToEntity(empleadosDTO, empleados);
        return empleadosRepository.save(empleados).getId();
    }

    public void update(final Long id, final EmpleadosDTO empleadosDTO) {
        final Empleados empleados = empleadosRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(empleadosDTO, empleados);
        empleadosRepository.save(empleados);
    }

    public void delete(final Long id) {
        empleadosRepository.deleteById(id);
    }

    private EmpleadosDTO mapToDTO(final Empleados empleados, final EmpleadosDTO empleadosDTO) {
        empleadosDTO.setId(empleados.getId());
        empleadosDTO.setNombre(empleados.getNombre());
        empleadosDTO.setSueldo(empleados.getSueldo());
        empleadosDTO.setIdPerfil(empleados.getIdPerfil() == null ? null : empleados.getIdPerfil().getId());
        return empleadosDTO;
    }

    private Empleados mapToEntity(final EmpleadosDTO empleadosDTO, final Empleados empleados) {
        empleados.setNombre(empleadosDTO.getNombre());
        empleados.setSueldo(empleadosDTO.getSueldo());
        final Perfiles idPerfil = empleadosDTO.getIdPerfil() == null ? null : perfilesRepository.findById(empleadosDTO.getIdPerfil())
                .orElseThrow(() -> new NotFoundException("idPerfil not found"));
        empleados.setIdPerfil(idPerfil);
        return empleados;
    }

    public boolean idPerfilExists(final Long id) {
        return empleadosRepository.existsByIdPerfilId(id);
    }

}
