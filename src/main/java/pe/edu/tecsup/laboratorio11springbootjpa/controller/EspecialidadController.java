package pe.edu.tecsup.laboratorio11springbootjpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.laboratorio11springbootjpa.model.Especialidad;
import pe.edu.tecsup.laboratorio11springbootjpa.service.EspecialidadService;


import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public List<Especialidad> listar() {
        return especialidadService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> buscarPorId(@PathVariable Integer id) {
        return especialidadService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Especialidad> guardar(@RequestBody Especialidad especialidad) {
        System.out.println("Recibido: " + especialidad.getDescripcionEsp());
        Especialidad guardada = especialidadService.guardar(especialidad);
        System.out.println("Guardado con ID: " + guardada.getCodEspec());
        return ResponseEntity.ok(guardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizar(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        return especialidadService.buscarPorId(id)
                .map(e -> {
                    especialidad.setCodEspec(id);
                    return ResponseEntity.ok(especialidadService.guardar(especialidad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return especialidadService.buscarPorId(id)
                .map(e -> {
                    especialidadService.eliminar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}