package net.restaurante.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.restaurante.springboot.model.Menu;
import net.restaurante.springboot.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;
	
	//GET ALL MENU
	public List<Menu> getALLMenu(){
		return menuRepository.findAll();
	}
	
	//GET MENU ID
	public Menu MenuById(Integer menuID) {
		final Optional<Menu> concatOptional = menuRepository.findById(menuID); 
		if(concatOptional.isPresent())
			return concatOptional.get();
		return null;
	}
	
	//CREATE MENU
	public Menu createMenu(Menu menu) {
		return menuRepository.save(menu);
	}
}
