package com.ec.repository;

import com.ec.entity.Repuesto;

import java.util.List;

public interface IRepuestoRepo {

	void crearRepuesto(Repuesto proveedor);
	Repuesto buscarRepuesto(Integer id);
	void borrarRepuesto(Integer id);
	void actualizarRepuesto(Repuesto proveedor);
	List<Repuesto> buscarTodosRepustos();
	
}
