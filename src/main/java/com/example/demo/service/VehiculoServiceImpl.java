package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Override
	public void crear(Vehiculo vehiculo) {
		
		this.iVehiculoRepository.agregar(vehiculo);
		
	}

	@Override
	public void borrar(String placa) {
		this.iVehiculoRepository.eliminar(placa);
		
	}

	@Override
	public Vehiculo listarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.obtener(placa);
	}

	@Override
	public List<Vehiculo> listarTodo() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.listarTodo();
	}

}
