package com.ec.repository;

import com.ec.entity.Proveedor;
import com.ec.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProveedorRepoImpl implements IProveedorRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearProveedor(Proveedor proveedor) {
        this.entityManager.persist(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Integer id) {
        return this.entityManager.find(Proveedor.class, id);
    }

    @Override
    public void borrarProveedor(Integer id) {
        this.entityManager.remove(this.entityManager.find(Proveedor.class, id));
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        this.entityManager.merge(proveedor);
    }

    @Override
    public List<Proveedor> buscarTodosProveedor() {
        TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("Select p from Proveedor p",Proveedor.class);
        return myQuery.getResultList();
    }
}
