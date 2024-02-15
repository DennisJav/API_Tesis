package com.ec.repository;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.ec.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuariosRepoImpl implements IUsuarioRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void crearUsuario(Usuario usuario) {
		this.entityManager.persist(usuario);
	}

	@Override
	public Usuario buscarUsuario(Integer id) {
		// TODO Auto-generated method stub
		Usuario user = this.entityManager.find(Usuario.class, id);
		return user;
	}

	@Override
	public void borrarUsuario(Integer id) {
		this.entityManager.remove(this.buscarUsuario(id));
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(usuario);
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		TypedQuery<Usuario> myQuery = this.entityManager.createQuery("Select u from Usuario u",Usuario.class);
		return myQuery.getResultList();
	}

	@Override
	public Usuario buscarPorCedula(String cedula) {
		TypedQuery<Usuario> myQuery = this.entityManager.createQuery("Select u from Usuario u Where u.cedula=:valor",Usuario.class);
		myQuery.setParameter("valor",cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Usuario buscarPorIdentificadorTecnico(String identificador) {
		TypedQuery<Usuario> myQuery = this.entityManager.createQuery("Select u from Usuario u Where u.identificador=:valor",Usuario.class);
		myQuery.setParameter("valor",identificador);
		return myQuery.getSingleResult();
	}

}
