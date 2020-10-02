package net.restaurante.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.restaurante.springboot.model.Empleado;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
