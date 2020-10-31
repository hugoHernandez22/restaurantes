package net.restaurante.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.MenuDetalle;

public interface MenuDetalleRepository extends JpaRepository<MenuDetalle, Integer> {

}
