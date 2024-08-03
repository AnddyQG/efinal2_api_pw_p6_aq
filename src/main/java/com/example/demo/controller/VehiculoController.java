package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;






import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/vehiculos")

public class VehiculoController {

	@Autowired
	private IVehiculoService iVehiculoService;
	//http://localhost:8082/API/v1.0/Vehiculo/vehiculos
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehiculo> guardar(@RequestBody Vehiculo vehiculo){
		
		this.iVehiculoService.crear(vehiculo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
		
	}
	@DeleteMapping(path ="/{placa}")
	public ResponseEntity<Vehiculo> eliminar(@PathVariable String placa)
	{
		this.iVehiculoService.borrar(placa);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);


	}

	@GetMapping(path ="/{placa}")
    public ResponseEntity<Vehiculo> listarPlaca(@PathVariable String placa)
	{
		Vehiculo vehiculo = this.iVehiculoService.listarPlaca(placa);
		
		//vehiculo.add(linkTo(methodOn(VehiculoController.class).listarPlaca(placa)).withSelfRel());
		return ResponseEntity.status(HttpStatus.OK).body(vehiculo);
	}

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehiculo>> listarTodos(){
		
        List<Vehiculo> vehiculos = this.iVehiculoService.listarTodo();
		
        //vehiculos.forEach(v -> v.add(linkTo(methodOn(VehiculoController.class).listarPlaca(v.getPlaca())).withSelfRel()));	
		return ResponseEntity.status(HttpStatus.OK).body(vehiculos);
		
	}
		


}
