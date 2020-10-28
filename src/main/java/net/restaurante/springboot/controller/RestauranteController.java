package net.restaurante.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.restaurante.springboot.repository.RestauranteRepository;
import net.restaurante.springboot.exception.ResourceNotFoundException;

import net.restaurante.springboot.model.Restaurante;
//@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/restaurante/")

public class RestauranteController {
	@Autowired
	private RestauranteRepository restauranteRepository;
	//GET restaurantes
	@GetMapping("restaurantes")
	public List<Restaurante> getAllRestaurante(){
		return this.restauranteRepository.findAll();
	}
	
	//GET restaurante id
	@GetMapping("/restaurantes/{id}")
	public ResponseEntity<Restaurante> getEmployeeById(@PathVariable(value = "id") Integer restauranteId)
			throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + restauranteId));
		return ResponseEntity.ok().body(restaurante);
	}
	
	//POST RESTAURANTE
	@PostMapping("restaurantes")
	public Restaurante createEmployee(@RequestBody Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}
	
	//PUT RESTAURANTE
	@PutMapping("/restaurantes/{id}")
	public ResponseEntity<Restaurante> updateEmployee(@PathVariable(value = "id") Integer restauranteId,
			@RequestBody Restaurante restauranteDetalles) throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + restauranteId));

		restaurante.setNOMBRE(restauranteDetalles.getNOMBRE());
		restaurante.setDIRECCION(restauranteDetalles.getDIRECCION());
		restaurante.setTELEFONO(restauranteDetalles.getTELEFONO());
		restaurante.setESTADO(restauranteDetalles.getESTADO());
		restaurante.setUSER_U(restauranteDetalles.getUSER_U());
		restaurante.setFECHA_U(restauranteDetalles.getFECHA_U());
		
		final Restaurante updatedRestaurante = restauranteRepository.save(restaurante);
		return ResponseEntity.ok(updatedRestaurante);
	}
	
	//DELETE RESTAURANTES 
	@DeleteMapping("/restaurantes/{id}")
	public Map<String, Boolean> deleteRestaurante(@PathVariable(value = "id") Integer restauranteId)
			throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("restaurant not found for this id :: " + restauranteId));

		restauranteRepository.delete(restaurante);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
