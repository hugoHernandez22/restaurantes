package net.restaurante.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.restaurante.springboot.exception.ResourceNotFoundException;

import net.restaurante.springboot.model.MenuDetalle;
import net.restaurante.springboot.repository.MenuDetalleRepository;
import net.restaurante.springboot.service.MenuDetalleService;



@RestController
@RequestMapping("/api/restaurante/")
public class MenuDetalleController {
	@Autowired
	private MenuDetalleService menuDetalleService;
	@Autowired
	private MenuDetalleRepository menuDetalleRepository;
	//GET MENU DETAIL
	@GetMapping("detalleMenu")
	public List<MenuDetalle> getALLMenuDetalle(){
		return this.menuDetalleService.getALLMenuDetalle();
	}
	
	//GET MENU DETAIL BY ID
	@GetMapping("/detalleMenu/{id}")
	public MenuDetalle getMenuDetalleById(@PathVariable Integer id)
	{
		return this.menuDetalleService.menuDetalleById(id);
	}
	
	//POST MENU DETAIL
	/*@PostMapping("detalleMenu")
	public MenuDetalle createMenuDetail(MenuDetalle menu) {
		return menuDetalleService.createMenuDetail(menu);
	}*/
	
	//post menu
		@PostMapping("detalleMenu")
		public MenuDetalle createMenuDetail(@RequestBody MenuDetalle menu) {
			return menuDetalleRepository.save(menu);
		}
	
	//PUT MENU DETAIL
	@PutMapping("/detalleMenu/{id}")
	public ResponseEntity<MenuDetalle> updateMenuDetalle(@PathVariable(value = "id") Integer menuID,
		@RequestBody MenuDetalle menuDetalle) throws ResourceNotFoundException {
		MenuDetalle menu = menuDetalleRepository.findById(menuID)
		.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuID));
					
		menu.setID_MENU(menu.getID_MENU());
		menu.setID_PRODUCTO(menu.getID_PRODUCTO());
		menu.setESTADO(menu.getESTADO());
		final MenuDetalle updatedMenu = menuDetalleRepository.save(menu);
		return ResponseEntity.ok(updatedMenu);
	}
	
	//DELETE MENU DETAIL
	@DeleteMapping("/detalleMenu/{id}")
	public Map<String, Boolean> deleteMenuDetalle(@PathVariable(value = "id") Integer menuID)
		throws ResourceNotFoundException {
			MenuDetalle menu = menuDetalleRepository.findById(menuID)
			.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuID));
			menuDetalleRepository.delete(menu);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	}
		

}
