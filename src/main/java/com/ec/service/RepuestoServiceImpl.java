package com.ec.service;

import com.ec.entity.Repuesto;
import com.ec.repository.IRepuestoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImpl implements  IRepuestoService{

    @Autowired
    private IRepuestoRepo iRepuestoRepo;

    @Override
    public void crearRepuesto(Repuesto repuesto) {
        this.iRepuestoRepo.crearRepuesto(repuesto);
    }

    @Override
    public Repuesto buscarRepuesto(Integer id) {
        return this.iRepuestoRepo.buscarRepuesto(id);
    }

    @Override
    public void modificarRepuesto(Repuesto repuesto) {
        this.iRepuestoRepo.actualizarRepuesto(repuesto);
    }

    @Override
    public void eliminarRepuesto(Integer id) {
        this.iRepuestoRepo.borrarRepuesto(id);
    }

    @Override
    public List<Repuesto> buscarTodosRepuestos() {
        return this.iRepuestoRepo.buscarTodosRepustos();
    }
}
