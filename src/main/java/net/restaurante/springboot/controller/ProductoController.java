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
import net.restaurante.springboot.model.Producto;

import net.restaurante.springboot.repository.ProductoRepository;

//@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/restaurante/")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	//GET RESTAURANTES
	@GetMapping("productos")
	public List<Producto> getALLProducto(){
		return this.productoRepository.findAll();
	}
	//GET RESTAURANTE BY ID
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") Integer productoId)
		throws ResourceNotFoundException {
			Producto producto = productoRepository.findById(productoId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productoId));
			return  ResponseEntity.ok().body(producto);
	}
	
	//POST PRODUCTO
	@PostMapping("productos")
	public Producto createProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	
	//PUT PRODUCTO
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Integer productoId,
		@RequestBody Producto productoteDetalles) throws ResourceNotFoundException {
		Producto producto = productoRepository.findById(productoId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productoId));

		producto.setPRODUCTO(productoteDetalles.getPRODUCTO());
		producto.setUSER_U(productoteDetalles.getUSER_U());
		producto.setFECHA_U(productoteDetalles.getFECHA_U());
		final Producto updatedProducto = productoRepository.save(producto);
		return ResponseEntity.ok(updatedProducto);
	}
	
	//DELETE RESTAURANTES 
	@DeleteMapping("/productos/{id}")
	public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") Integer productoId)
		throws ResourceNotFoundException {
		Producto producto = productoRepository.findById(productoId)
			.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productoId));
			productoRepository.delete(producto);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	}
	
 }
