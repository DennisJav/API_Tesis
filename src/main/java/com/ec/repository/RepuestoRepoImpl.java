package com.ec.repository;

import com.ec.entity.Proveedor;
import com.ec.entity.Repuesto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RepuestoRepoImpl implements IRepuestoRepo{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void crearRepuesto(Repuesto repuesto) {
        this.entityManager.persist(repuesto);
    }

    @Override
    public Repuesto buscarRepuesto(Integer id) {
        return this.entityManager.find(Repuesto.class,id);
    }

    @Override
    public void borrarRepuesto(Integer id) {
        this.entityManager.remove(this.entityManager.find(Repuesto.class,id));
    }

    @Override
    public void actualizarRepuesto(Repuesto proveedor) {
        this.entityManager.merge(proveedor);
    }

    @Override
    public List<Repuesto> buscarTodosRepustos() {
        TypedQuery<Repuesto> myQuery = this.entityManager.createQuery("Select r from Repuesto r",Repuesto.class);
        return myQuery.getResultList();
    }
}
