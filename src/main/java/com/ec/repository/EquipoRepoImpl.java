package com.ec.repository;

import com.ec.entity.Usuario;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.ec.entity.Equipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class EquipoRepoImpl implements IEquipoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crearEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(equipo);
	}

	@Override
	public Equipo buscarEquipo(Integer id) {
		// TODO Auto-generated method stub
		
		Equipo equipo =this.entityManager.find(Equipo.class, id);
		return equipo;
		
	}

	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(equipo);
		
	}

	@Override
	public void borrarEquipo(Integer id) {
		// TODO Auto-generated method stub
		Equipo equipo = this.entityManager.find(Equipo.class, id);
		this.entityManager.remove(equipo);
	}

	@Override
	public Equipo buscarEquipoPorSerie(String serie) {
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery("Select e from Equipo e Where e.serie=:valor",Equipo.class);
		myQuery.setParameter("valor",serie);
		return myQuery.getSingleResult();
	}


}
