package com.ec.service;

import com.ec.entity.Equipo;

public interface IEquipoService {
    void crearEquipo(Equipo equipo);
    Equipo buscarEquipo(Integer id);

    void modificarEquipo(Equipo equipo);

    void eliminarEquipo(Integer id);

    Equipo buscarEquipoSerie(String serie);

}
