package com.ec.repository;


import com.ec.entity.Proveedor;

import java.util.List;

public interface IProveedorRepo {

	void crearProveedor(Proveedor proveedor);
	Proveedor buscarProveedor(Integer id);
	void borrarProveedor(Integer id);
	void actualizarProveedor(Proveedor proveedor);

	List<Proveedor> buscarTodosProveedor();
	
}
