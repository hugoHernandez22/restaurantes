package net.restaurante.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.restaurante.springboot.model.Ventas;
import net.restaurante.springboot.repository.VentaRepository;

@Service
public class VentasService {
	@Autowired
	private VentaRepository ventaRepository;
	
	//GET ALL SALES
	public List<Ventas> getALLVentas(){
		return ventaRepository.findAll();
	}
	
	//GET MENU DETAIL ID
	public Ventas ventaById(Integer ventaID) {
		final Optional<Ventas> concatOptional = ventaRepository.findById(ventaID); 
		if(concatOptional.isPresent())
			return concatOptional.get();
		return null;
	}
	
	//CREATE MENU
	public Ventas createVentas(Ventas venta) {
		return ventaRepository.save(venta);
	}
	
	
}
