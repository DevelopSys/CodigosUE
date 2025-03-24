package com.borja.ue.usuarioapp.service;

import com.borja.ue.usuarioapp.domain.Empleados;
import com.borja.ue.usuarioapp.domain.Perfiles;
import com.borja.ue.usuarioapp.model.PerfilesDTO;
import com.borja.ue.usuarioapp.repos.EmpleadosRepository;
import com.borja.ue.usuarioapp.repos.PerfilesRepository;
import com.borja.ue.usuarioapp.util.NotFoundException;
import com.borja.ue.usuarioapp.util.ReferencedWarning;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PerfilesService {

    private final PerfilesRepository perfilesRepository;
    private final EmpleadosRepository empleadosRepository;

    public PerfilesService(final PerfilesRepository perfilesRepository,
            final EmpleadosRepository empleadosRepository) {
        this.perfilesRepository = perfilesRepository;
        this.empleadosRepository = empleadosRepository;
    }

    public List<PerfilesDTO> findAll() {
        final List<Perfiles> perfileses = perfilesRepository.findAll(Sort.by("id"));
        return perfileses.stream()
                .map(perfiles -> mapToDTO(perfiles, new PerfilesDTO()))
                .toList();
    }

    public PerfilesDTO get(final Long id) {
        return perfilesRepository.findById(id)
                .map(perfiles -> mapToDTO(perfiles, new PerfilesDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PerfilesDTO perfilesDTO) {
        final Perfiles perfiles = new Perfiles();
        mapToEntity(perfilesDTO, perfiles);
        return perfilesRepository.save(perfiles).getId();
    }

    public void update(final Long id, final PerfilesDTO perfilesDTO) {
        final Perfiles perfiles = perfilesRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(perfilesDTO, perfiles);
        perfilesRepository.save(perfiles);
    }

    public void delete(final Long id) {
        perfilesRepository.deleteById(id);
    }

    private PerfilesDTO mapToDTO(final Perfiles perfiles, final PerfilesDTO perfilesDTO) {
        perfilesDTO.setId(perfiles.getId());
        perfilesDTO.setNombre(perfiles.getNombre());
        return perfilesDTO;
    }

    private Perfiles mapToEntity(final PerfilesDTO perfilesDTO, final Perfiles perfiles) {
        perfiles.setNombre(perfilesDTO.getNombre());
        return perfiles;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final Perfiles perfiles = perfilesRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Empleados idPerfilEmpleados = empleadosRepository.findFirstByIdPerfil(perfiles);
        if (idPerfilEmpleados != null) {
            referencedWarning.setKey("perfiles.empleados.idPerfil.referenced");
            referencedWarning.addParam(idPerfilEmpleados.getId());
            return referencedWarning;
        }
        return null;
    }

}
