package com.ec.repository;


import com.ec.entity.Proveedor;
import com.ec.service.dto.ProveedorTO;

import java.util.List;

public interface IProveedorRepo {

	void crearProveedor(Proveedor proveedor);
	Proveedor buscarProveedor(Integer id);
	void borrarProveedor(Integer id);
	void actualizarProveedor(Proveedor proveedor);

	List<Proveedor> buscarTodosProveedor();
	Proveedor buscarPorNombre(String nombreEmpresa);

	List<Proveedor> buscarPorNombreLista(String nombre);

	Integer eliminarProveedorPorNombre(String nombreEmpresa);

	Integer eliminarProveedorPorIdentificacion(Proveedor proveedor);


	Proveedor buscarPorIdentificacion(String identificacion);

	Proveedor proveedorPorCodBarraRepu(String codBarras);

	List<String> listarPorNombre();

	List<Proveedor> buscarPorNombreOIdentifi(String nombreOIdenti);


	
}
