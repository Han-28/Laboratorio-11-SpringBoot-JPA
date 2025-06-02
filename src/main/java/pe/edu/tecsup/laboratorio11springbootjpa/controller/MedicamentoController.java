package pe.edu.tecsup.laboratorio11springbootjpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.laboratorio11springbootjpa.model.Medicamento;
import pe.edu.tecsup.laboratorio11springbootjpa.service.MedicamentoService;


import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Medicamento> listar() {
        return medicamentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> buscarPorId(@PathVariable Integer id) {
        return medicamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicamento guardar(@RequestBody Medicamento medicamento) {
        return medicamentoService.guardar(medicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> actualizar(@PathVariable Integer id, @RequestBody Medicamento medicamento) {
        return medicamentoService.buscarPorId(id)
                .map(m -> {
                    medicamento.setCodMedicamento(id);
                    return ResponseEntity.ok(medicamentoService.guardar(medicamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return medicamentoService.buscarPorId(id)
                .map(m -> {
                    medicamentoService.eliminar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}