package net.restaurante.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.restaurante.springboot.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

}
