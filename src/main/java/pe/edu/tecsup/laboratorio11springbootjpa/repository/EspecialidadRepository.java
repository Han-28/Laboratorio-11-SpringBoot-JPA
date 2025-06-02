package pe.edu.tecsup.laboratorio11springbootjpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.laboratorio11springbootjpa.model.Especialidad;


@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> { }