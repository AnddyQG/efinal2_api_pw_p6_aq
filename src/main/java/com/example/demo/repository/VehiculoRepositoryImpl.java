package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void agregar(Vehiculo vehiculo) {
		
		this.entityManager.persist(vehiculo);
		
		
	}

	@Override
	public void eliminar(String placa) {
		String jpql="DELETE FROM Vehiculo v WHERE v.placa= :placa";
		Query query= this.entityManager.createQuery(jpql);
		
		query.setParameter("placa", placa);
		query.executeUpdate();
		
	}

	@Override
	public Vehiculo obtener(String placa) {
		String jpql= "SELECT v FROM Vehiculo v WHERE v.placa= :placa";
		TypedQuery<Vehiculo> query = this.entityManager.createQuery(jpql,Vehiculo.class);
		query.setParameter("placa", placa);
		
		return query.getSingleResult();
	}

	@Override
	public List<Vehiculo> listarTodo() {
		String jpql= "SELECT v From Vehiculo v";
		TypedQuery<Vehiculo> query= this.entityManager.createQuery(jpql,Vehiculo.class);
		return query.getResultList();
	}

}
