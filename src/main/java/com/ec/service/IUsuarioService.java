package com.ec.service;

import com.ec.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
	void guardarUsuario(Usuario usuario);
	Usuario buscarUsuario(Integer id);
	void borrarUsuario(Integer id);
	void actualizarUsuario(Usuario usuario);

	List<Usuario> listarTodosUsuarios();

	Usuario buscarPorCedula(String cedula);
}
