package com.ec.repository;


import com.ec.entity.Equipo;

public interface IEquipoRepo {
	
	void crearEquipo(Equipo equipo);
	Equipo buscarEquipo(Integer id);
	void actualizarEquipo(Equipo equipo);
	void borrarEquipo(Integer id);

	Equipo buscarEquipoPorSerie(String serie);
}
