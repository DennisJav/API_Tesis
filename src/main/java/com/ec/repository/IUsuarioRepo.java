package com.ec.repository;

import com.ec.entity.Usuario;

import java.util.List;

public interface IUsuarioRepo {

	void crearUsuario(Usuario usuario);
	Usuario buscarUsuario(Integer id);
	void borrarUsuario(Integer id);
	void actualizarUsuario(Usuario usuario);

	List<Usuario> buscarTodosUsuarios();

	Usuario buscarPorCedula(String cedula);

	Usuario buscarPorIdentificadorTecnico(String identificador);

	
}
