package com.example.demo.repository;
import java.util.List;
import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	void agregar(Vehiculo vehiculo);
	void eliminar(String placa);
	Vehiculo obtener(String placa);
	List<Vehiculo> listarTodo();
	
}
