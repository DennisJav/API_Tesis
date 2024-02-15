package com.ec.service;

import com.ec.entity.Repuesto;

import java.util.List;

public interface IRepuestoService {
    void crearRepuesto(Repuesto repuesto);
    Repuesto buscarRepuesto(Integer id);
    void modificarRepuesto(Repuesto repuesto);

    void eliminarRepuesto(Integer id);

    List<Repuesto> buscarTodosRepuestos();
}
