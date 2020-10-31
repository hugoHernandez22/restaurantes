package net.restaurante.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.Menu;

public interface MenuRepository  extends JpaRepository<Menu, Integer>{

}
