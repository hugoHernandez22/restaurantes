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
import net.restaurante.springboot.model.Empleado;
import net.restaurante.springboot.repository.EmpleadoRepository;
//@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/restaurante/")
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	//get empleados
	@GetMapping("empleados")
	public List<Empleado> getAllEmpleado(){
		return this.empleadoRepository.findAll();
	}
	//get empleado {id}
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> getEmployeeById(@PathVariable(value = "id") Integer empleadoId)
			throws ResourceNotFoundException {
		Empleado empleado = empleadoRepository.findById(empleadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empleadoId));
		return ResponseEntity.ok().body(empleado);
	}
	//post empleado
	@PostMapping("empleados")
	public Empleado createEmployee(@RequestBody Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	//put empleado
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> updateEmployee(@PathVariable(value = "id") Integer empleadoId,
			@RequestBody Empleado empleadoDetalles) throws ResourceNotFoundException {
		Empleado empleado = empleadoRepository.findById(empleadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empleadoId));

		empleado.setCUI(empleadoDetalles.getCUI());
		empleado.setNOMBRES(empleadoDetalles.getNOMBRES());
		empleado.setAPELLIDOS(empleadoDetalles.getAPELLIDOS());
		empleado.setDIRECCION(empleadoDetalles.getDIRECCION());
		empleado.setTELEFONO(empleadoDetalles.getTELEFONO());
		empleado.setTIPO(empleadoDetalles.getTIPO());
		empleado.setESTADO(empleadoDetalles.getESTADO());
		
		
		final Empleado updatedEmpleado = empleadoRepository.save(empleado);
		return ResponseEntity.ok(updatedEmpleado);
	}

	//delete empleado
	@DeleteMapping("/empleados/{id}")
	public Map<String, Boolean> deleteEmpleado(@PathVariable(value = "id") Integer empleadoId)
			throws ResourceNotFoundException {
		Empleado empleado = empleadoRepository.findById(empleadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empleadoId));

		empleadoRepository.delete(empleado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
