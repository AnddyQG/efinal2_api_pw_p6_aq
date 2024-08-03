package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoService {

	void crear(Vehiculo vehiculo);
	
	void borrar(String placa);
	Vehiculo listarPlaca(String placa);
	List<Vehiculo> listarTodo();
	
}
