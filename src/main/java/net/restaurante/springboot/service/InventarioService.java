package net.restaurante.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.restaurante.springboot.model.Inventario;
import net.restaurante.springboot.repository.InventarioRepository;

@Service
public class InventarioService {
	@Autowired
	private InventarioRepository inventarioRepository;
	public List<Inventario> getALLInventario(){
		return inventarioRepository.findAll();
	}
	
	public Inventario getInventarioById(Integer inventarioId) {
		final Optional<Inventario> concatOptional = inventarioRepository.findById(inventarioId); 
		if(concatOptional.isPresent())
			return concatOptional.get();
		return null;
	}
	
	public Inventario createInventario(Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	
	
}
