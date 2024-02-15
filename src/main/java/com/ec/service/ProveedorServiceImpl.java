package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.repository.IProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepo iProveedorRepo;

    @Override
    public void crearProovedor(Proveedor proveedor) {
        this.iProveedorRepo.crearProveedor(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Integer id) {
        return this.iProveedorRepo.buscarProveedor(id);
    }

    @Override
    public void eliminarProveedor(Integer id) {
        this.iProveedorRepo.borrarProveedor(id);
    }

    @Override
    public void modificarProveedor(Proveedor proveedor) {
        this.iProveedorRepo.actualizarProveedor(proveedor);
    }

    @Override
    public List<Proveedor> buscarTodosProveedores() {
        return this.iProveedorRepo.buscarTodosProveedor();
    }
}
