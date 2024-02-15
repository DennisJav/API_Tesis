package com.ec.service;

import com.ec.entity.Equipo;
import com.ec.repository.IEquipoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoServiceImpl implements IEquipoService{

    @Autowired
    private IEquipoRepo iEquipoRepo;


    @Override
    public void crearEquipo(Equipo equipo) {
        this.iEquipoRepo.crearEquipo(equipo);
    }

    @Override
    public Equipo buscarEquipo(Integer id) {
        return this.iEquipoRepo.buscarEquipo(id);
    }

    @Override
    public void modificarEquipo(Equipo equipo) {
        this.iEquipoRepo.actualizarEquipo(equipo);
    }

    @Override
    public void eliminarEquipo(Integer id) {
        this.iEquipoRepo.borrarEquipo(id);
    }

    @Override
    public Equipo buscarEquipoSerie(String serie) {
        return this.iEquipoRepo.buscarEquipoPorSerie(serie);
    }
}
