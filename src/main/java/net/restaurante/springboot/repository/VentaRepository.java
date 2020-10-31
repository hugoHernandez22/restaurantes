package net.restaurante.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.Ventas;

public interface VentaRepository  extends JpaRepository<Ventas, Integer>{

}
