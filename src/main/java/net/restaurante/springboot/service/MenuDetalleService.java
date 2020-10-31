package net.restaurante.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.restaurante.springboot.model.MenuDetalle;
import net.restaurante.springboot.repository.MenuDetalleRepository;
@Service
public class MenuDetalleService {
	@Autowired
	private MenuDetalleRepository menuDetalleRepository;
	
	//GET ALL MENU DETAIL
	public List<MenuDetalle> getALLMenuDetalle(){
		return menuDetalleRepository.findAll();
	}
	
	//GET MENU DETAIL ID
	public MenuDetalle menuDetalleById(Integer menuID) {
		final Optional<MenuDetalle> concatOptional = menuDetalleRepository.findById(menuID); 
		if(concatOptional.isPresent())
			return concatOptional.get();
		return null;
	}
	
	//CREATE MENU
	public MenuDetalle createMenuDetail(MenuDetalle menu) {
		return menuDetalleRepository.save(menu);
	}
}
