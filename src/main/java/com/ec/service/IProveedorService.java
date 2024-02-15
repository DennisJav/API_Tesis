package com.ec.service;

import com.ec.entity.Proveedor;

import java.util.List;

public interface IProveedorService {

    void crearProovedor(Proveedor proveedor);
    Proveedor buscarProveedor(Integer id);
    void eliminarProveedor(Integer id);

    void modificarProveedor(Proveedor proveedor);
    List<Proveedor> buscarTodosProveedores();



}
