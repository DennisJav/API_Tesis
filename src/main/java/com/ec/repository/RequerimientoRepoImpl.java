package com.ec.repository;

import com.ec.entity.Requerimiento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.awt.font.TextHitInfo;

public class RequerimientoRepoImpl implements IRequerimientoRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearRequerimiento(Requerimiento requerimiento) {
        this.entityManager.persist(requerimiento);
    }

    @Override
    public Requerimiento buscarRequerimiento(Integer id) {
        return this.entityManager.find(Requerimiento.class, id);
    }

    @Override
    public void borrarRequerimiento(Integer id) {
        this.entityManager.remove(this.entityManager.find(Requerimiento.class, id));
    }

    @Override
    public void actualizarRequerimiento(Requerimiento requerimiento) {
        this.entityManager.merge(requerimiento);
    }
}
