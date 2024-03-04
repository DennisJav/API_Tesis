package com.ec.repository;

import com.ec.entity.Repuesto;

import java.util.List;

public interface IRepuestoRepo {

	Repuesto crearRepuesto(Repuesto proveedor);
	Repuesto buscarRepuesto(Integer id);
	Integer borrarRepuesto(String codBarras);
	void actualizarRepuesto(Repuesto proveedor);
	List<Repuesto> buscarTodosRepustos();

	Repuesto buscarPorCodBarras(String codBarras);

	List<Repuesto> buscarPorCodBarraNombre(String codBarrasONombre);
	
}
