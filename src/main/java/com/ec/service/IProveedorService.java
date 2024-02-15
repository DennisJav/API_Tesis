package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.service.dto.ProveedorTO;

import java.util.List;

public interface IProveedorService {

    ProveedorTO crearProovedor(ProveedorTO proveedor);
    Proveedor buscarProveedor(Integer id);
    void eliminarProveedor(Integer id);

    Integer eliminarProveedorPorNombre(String nombreEmpresa);

    ProveedorTO modificarProveedor(ProveedorTO proveedor);
    List<ProveedorTO> buscarTodosProveedores();


     ProveedorTO buscarPorNombre(String nombreEmpresa);

    List<ProveedorTO> listarPorNombre(String nombreEmpresa);

}
