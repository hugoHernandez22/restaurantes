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

import net.restaurante.springboot.model.Menu;
import net.restaurante.springboot.repository.MenuRepository;
import net.restaurante.springboot.service.MenuService;

@RestController
@RequestMapping("/api/restaurante/")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuRepository menuRepository;
	
	//GET MENU
	@GetMapping("menu")
	public List<Menu> getALLMenu(){
		return this.menuService.getALLMenu();
	}
	
	//GET MENU BY ID
	@GetMapping("/menu/{id}")
	public Menu getMenuById(@PathVariable Integer id)
	{
		return this.menuService.MenuById(id);
	}
	
	//POST MENU
	/*@PostMapping("menu")
	public Menu createMenu(Menu menu) {
		return menuService.createMenu(menu);
	}*/
	//post menu
	@PostMapping("menu")
	public Menu createMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}
	
	//PUT MENU
	@PutMapping("/menu/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable(value = "id") Integer menuID,
		@RequestBody Menu menuDetalles) throws ResourceNotFoundException {
		Menu menu = menuRepository.findById(menuID)
		.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuID));
				
			menu.setNOMBRE(menu.getNOMBRE());
			menu.setID_RESTAURANTE(menu.getID_RESTAURANTE());
			menu.setESTADO(menu.getESTADO());
			final Menu updatedMenu = menuRepository.save(menu);
		return ResponseEntity.ok(updatedMenu);
	}
			
	//DELETE MENU 
	@DeleteMapping("/menu/{id}")
	public Map<String, Boolean> deleteMenu(@PathVariable(value = "id") Integer menuID)
		throws ResourceNotFoundException {
			Menu menu = menuRepository.findById(menuID)
			.orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuID));
			menuRepository.delete(menu);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	}
	

}
