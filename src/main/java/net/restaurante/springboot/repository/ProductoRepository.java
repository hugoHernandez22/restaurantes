package net.restaurante.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
