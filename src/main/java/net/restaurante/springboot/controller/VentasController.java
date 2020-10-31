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
import net.restaurante.springboot.model.Ventas;
import net.restaurante.springboot.repository.VentaRepository;
import net.restaurante.springboot.service.VentasService;

@RestController
@RequestMapping("/api/restaurante/")
public class VentasController {
	@Autowired
	private VentasService ventaservice;
	@Autowired
	private VentaRepository ventaRepository;
	
	//GET SALES
	@GetMapping("ventas")
	public List<Ventas> getALLVentas(){
		return this.ventaservice.getALLVentas();
	}
	
	//GET SALES ID
	@GetMapping("/ventas/{id}")
	public Ventas getVentasById(@PathVariable Integer id)
	{
		return this.ventaservice.ventaById(id);
	}
	
	//POST SALE
	/*@PostMapping("ventas")
	public Ventas createVentas(Ventas venta) {
		return ventaservice.createVentas(venta);
	}*/
	//post ventas
	@PostMapping("ventas")
	public Ventas createVenta(@RequestBody Ventas venta) {
		return ventaRepository.save(venta);
	}
	
	//PUT SALES
	@PutMapping("/ventas/{id}")
	public ResponseEntity<Ventas> updateVentas(@PathVariable(value = "id") Integer ventaID,
		@RequestBody Ventas ventas) throws ResourceNotFoundException {
		Ventas venta = ventaRepository.findById(ventaID)
		.orElseThrow(() -> new ResourceNotFoundException("Sale not found for this id :: " + ventaID));
		
		venta.setID_RESTAURANTE(venta.getID_RESTAURANTE());
		venta.setID_MENU(venta.getID_MENU());
		venta.setFECHA(venta.getFECHA());
		venta.setESTADO(venta.getESTADO());
		venta.setUSER_U(venta.getUSER_U());
		venta.setFECHA_U(venta.getFECHA_U());
		final Ventas updatedVenta = ventaRepository.save(venta);
		return ResponseEntity.ok(updatedVenta);
	}
	
	//DELETE MENU DETAIL
	@DeleteMapping("/ventas/{id}")
	public Map<String, Boolean> deleteVentas(@PathVariable(value = "id") Integer ventaID)
		throws ResourceNotFoundException {
			Ventas venta = ventaRepository.findById(ventaID)
			.orElseThrow(() -> new ResourceNotFoundException("Sales not found for this id :: " + ventaID));
			ventaRepository.delete(venta);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	}
	
}
