package net.restaurante.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.Inventario;
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
