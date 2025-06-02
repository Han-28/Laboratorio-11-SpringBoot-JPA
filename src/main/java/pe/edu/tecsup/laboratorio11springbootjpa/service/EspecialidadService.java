package pe.edu.tecsup.laboratorio11springbootjpa.service;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.laboratorio11springbootjpa.model.Especialidad;
import pe.edu.tecsup.laboratorio11springbootjpa.repository.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> listar() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> buscarPorId(Integer id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad guardar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public void eliminar(Integer id) {
        especialidadRepository.deleteById(id);
    }
}