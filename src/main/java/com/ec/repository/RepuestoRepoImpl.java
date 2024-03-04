package com.ec.repository;

import com.ec.entity.Proveedor;
import com.ec.entity.Repuesto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class RepuestoRepoImpl implements IRepuestoRepo{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Repuesto crearRepuesto(Repuesto repuesto) {
        this.entityManager.persist(repuesto);
        return repuesto;
    }

    @Override
    public Repuesto buscarRepuesto(Integer id) {
        return this.entityManager.find(Repuesto.class,id);
    }

    @Override
    public Integer borrarRepuesto(String codBarras) {
        Integer flag =0;
        try{
            this.entityManager.remove(this.buscarPorCodBarras(codBarras));
            flag=1;
        }catch(NoResultException ex){
            log.error(ex.getMessage());
        }

        return flag;
    }

    @Override
    public void actualizarRepuesto(Repuesto repuesto) {
        System.out.println("Legando al repo: "+repuesto.toString());
       this.entityManager.merge(repuesto);
    }

    @Override
    public List<Repuesto> buscarTodosRepustos() {
        TypedQuery<Repuesto> myQuery = this.entityManager.createQuery("Select r from Repuesto r",Repuesto.class);
        return myQuery.getResultList();
    }

    @Override
    public Repuesto buscarPorCodBarras(String codBarras) {
        TypedQuery<Repuesto> myQuery = this.entityManager.createQuery("Select r from Repuesto r Where r.codBarras=:codBarras",Repuesto.class);
        return myQuery.setParameter("codBarras",codBarras).getSingleResult();
    }

    @Override
    public List<Repuesto> buscarPorCodBarraNombre(String codBarrasONombre) {
        TypedQuery<Repuesto> myQ;

        if (codBarrasONombre != null) {
            String codBarrasONombreLoweCase = codBarrasONombre.toLowerCase();
            myQ = this.entityManager.createQuery("SELECT r FROM Repuesto r WHERE LOWER(r.codBarras) LIKE :codBarras OR LOWER(r.nombre) LIKE :nombre", Repuesto.class);
            myQ.setParameter("codBarras", "%" + codBarrasONombreLoweCase + "%");
            myQ.setParameter("nombre", "%" + codBarrasONombreLoweCase + "%");
        } else {
            return new ArrayList<>();
        }
        return myQ.getResultList();
    }
}
