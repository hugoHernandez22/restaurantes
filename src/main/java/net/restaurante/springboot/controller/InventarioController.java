package net.restaurante.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import net.restaurante.springboot.exception.ResourceNotFoundException;
import net.restaurante.springboot.model.Inventario;
import net.restaurante.springboot.repository.InventarioRepository;
import net.restaurante.springboot.service.InventarioService;
//@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/restaurante/")
public class InventarioController {
	@Autowired
	private InventarioService inventarioService;
	//private InventarioRepository inventarioRepository;
	@Autowired
	private InventarioRepository inventarioRepository;
	//GET INVENTARIO 
	@GetMapping("inventario")
	public List<Inventario> getALLInventario(){
		return this.inventarioService.getALLInventario();
	}
	//GET INVENTARIO BY ID
	@GetMapping("/inventario/{id}")
	public Inventario getInventarioById(@PathVariable Integer id)
	{
		return this.inventarioService.getInventarioById(id);
	}
	
	//POST INVENTARIO
		/*@PostMapping("inventario")
		public Inventario createInventario(Inventario inventario) {
			return inventarioService.createInventario(inventario);
		}*/
	//post inventario
	@PostMapping("inventario")
	public Inventario createInventario(@RequestBody Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
		
	//PUT INVENTARIO
		@PutMapping("/inventario/{id}")
		public ResponseEntity<Inventario> updateInventario(@PathVariable(value = "id") Integer inventarioId,
			@RequestBody Inventario inventarioDetalles) throws ResourceNotFoundException {
			Inventario inventario = inventarioRepository.findById(inventarioId)
			.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventarioId));
			
			inventario.setPRODUCTO(inventarioDetalles.getPRODUCTO());
			inventario.setCANTIDAD(inventarioDetalles.getCANTIDAD());
			inventario.setPRECIO(inventarioDetalles.getPRECIO());
			inventario.setESTADO(inventarioDetalles.getESTADO());
			inventario.setUSER_U(inventarioDetalles.getUSER_U());
			inventario.setFECHA_U(inventarioDetalles.getFECHA_U());
			final Inventario updatedInventario = inventarioRepository.save(inventario);
			return ResponseEntity.ok(updatedInventario);
		}
		
		
		//DELETE INVENTARIO 
		@DeleteMapping("/inventario/{id}")
		public Map<String, Boolean> deleteInventario(@PathVariable(value = "id") Integer inventarioId)
			throws ResourceNotFoundException {
			Inventario inventario = inventarioRepository.findById(inventarioId)
			.orElseThrow(() -> new ResourceNotFoundException("Inventario not found for this id :: " + inventarioId));
			inventarioRepository.delete(inventario);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
	/*//GET INVENTARIO
	@GetMapping("inventario")
	public List<Inventario> getALLInventario(){
		return this.inventarioRepository.findAll();
	}
	
	//GET INVENTARIO BY ID
	@GetMapping("/inventario/{id}")
	public ResponseEntity<Inventario> getInventarioById(@PathVariable(value = "id") Integer inventarioId)
		throws ResourceNotFoundException {
		Inventario inventario = inventarioRepository.findById(inventarioId)
					.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventarioId));
			return  ResponseEntity.ok().body(inventario);
	}
	
	//POST INVENTARIO
	@PostMapping("inventario")
	public Inventario createInventario(@RequestBody Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	
	//PUT INVENTARIO
	@PutMapping("/inventario/{id}")
	public ResponseEntity<Inventario> updateInventario(@PathVariable(value = "id") Integer inventarioId,
		@RequestBody Inventario inventarioDetalles) throws ResourceNotFoundException {
		Inventario inventario = inventarioRepository.findById(inventarioId)
		.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventarioId));
		
		inventario.setPRODUCTO(inventarioDetalles.getPRODUCTO());
		inventario.setCANTIDAD(inventarioDetalles.getCANTIDAD());
		inventario.setPRECIO(inventarioDetalles.getPRECIO());
		inventario.setESTADO(inventarioDetalles.getESTADO());
		inventario.setUSER_U(inventarioDetalles.getUSER_U());
		inventario.setFECHA_U(inventarioDetalles.getFECHA_U());
		final Inventario updatedInventario = inventarioRepository.save(inventario);
		return ResponseEntity.ok(updatedInventario);
	}
		
	//DELETE INVENTARIO 
	@DeleteMapping("/inventario/{id}")
	public Map<String, Boolean> deleteInventario(@PathVariable(value = "id") Integer inventarioId)
		throws ResourceNotFoundException {
		Inventario inventario = inventarioRepository.findById(inventarioId)
		.orElseThrow(() -> new ResourceNotFoundException("Inventario not found for this id :: " + inventarioId));
		inventarioRepository.delete(inventario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
