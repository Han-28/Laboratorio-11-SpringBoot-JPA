package pe.edu.tecsup.laboratorio11springbootjpa.service;


import org.springframework.stereotype.Service;
import pe.edu.tecsup.laboratorio11springbootjpa.model.Medicamento;
import pe.edu.tecsup.laboratorio11springbootjpa.repository.MedicamentoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> listar() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> buscarPorId(Integer id) {
        return medicamentoRepository.findById(id);
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void eliminar(Integer id) {
        medicamentoRepository.deleteById(id);
    }
}