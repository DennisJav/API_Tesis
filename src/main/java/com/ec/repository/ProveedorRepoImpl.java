package com.ec.repository;

import com.ec.entity.Proveedor;
import com.ec.entity.Repuesto;
import com.ec.entity.Usuario;
import com.ec.service.dto.ProveedorTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

        System.out.println("proveedor en el repo: "+proveedor.toString());
        this.entityManager.merge(proveedor);
    }

    @Override
    public List<Proveedor> buscarTodosProveedor() {
        TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("Select p from Proveedor p",Proveedor.class);
        return myQuery.getResultList();
    }

    @Override
    public Proveedor buscarPorNombre(String nombreEmpresa) {
        TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("Select p from Proveedor p WHERE p.empresa=:empresa",Proveedor.class);
        return myQuery.setParameter("empresa",nombreEmpresa).getSingleResult();
    }

    @Override
    public List<Proveedor> buscarPorNombreLista(String nombre) {
        TypedQuery<Proveedor> myQuery = this.entityManager.createQuery("Select p from Proveedor p WHERE p.empresa LIKE :empresa",Proveedor.class);
        return myQuery.setParameter("empresa","%"+nombre+"%").getResultList();
    }

    @Override
    public Integer eliminarProveedorPorNombre(String nombreEmpresa) {
        Integer flag = 0;

        try{
            Proveedor prov = this.buscarPorNombre(nombreEmpresa);
            this.entityManager.remove(prov);
            flag =1;
        }catch (NoResultException ex){
            log.error("No hay resultado: "+ex.getMessage());
        }

        return flag;
    }

    @Override
    public Integer eliminarProveedorPorIdentificacion(Proveedor proveedor) {
        Integer flag=0;
        try{
            this.entityManager.remove(proveedor);
            flag=1;
        }catch(NoResultException ex){
            log.error(ex.getMessage());
        }
        return flag;
    }

    @Override
    public Proveedor buscarPorIdentificacion(String identificacion) {
        TypedQuery<Proveedor> myQ = this.entityManager.createQuery("SELECT p FROM Proveedor p WHERE p.identificacion =: identificacion",Proveedor.class);
        return myQ.setParameter("identificacion",identificacion).getSingleResult();
    }

    @Override
    public Proveedor proveedorPorCodBarraRepu(String codBarras) {
        TypedQuery<Proveedor> myQ = this.entityManager.createQuery("SELECT r.proveedor FROM Repuesto r WHERE r.codBarras=:codBarras",Proveedor.class);
        return myQ.setParameter("codBarras",codBarras).getSingleResult();
    }

    @Override
    public List<String> listarPorNombre() {
        TypedQuery<String> myQ = this.entityManager.createQuery("SELECT p.empresa From Proveedor p ",String.class);
        return myQ.getResultList();
    }

    @Override
    public List<Proveedor> buscarPorNombreOIdentifi(String nombreOIdenti) {
        TypedQuery<Proveedor> myQ;

        if (nombreOIdenti != null) {
            String nombreOIdentilowerCase = nombreOIdenti.toLowerCase();
            myQ = this.entityManager.createQuery("SELECT p FROM Proveedor p WHERE LOWER(p.empresa) LIKE :nombre OR LOWER(p.identificacion) LIKE :identificacion", Proveedor.class);
            myQ.setParameter("nombre", "%" + nombreOIdentilowerCase + "%");
            myQ.setParameter("identificacion", "%" + nombreOIdentilowerCase + "%");
        } else {
            return new ArrayList<>();
        }
        return myQ.getResultList();
    }
}
