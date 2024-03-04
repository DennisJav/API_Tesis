package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.service.dto.ProveedorTO;

import java.util.List;

public interface IProveedorService {

    ProveedorTO crearProovedor(ProveedorTO proveedor);
    Proveedor buscarProveedor(Integer id);
    void eliminarProveedor(Integer id);

    Integer eliminarProveedorPorNombre(String nombreEmpresa);

    Integer eliminarProveedorPorIdentificacion(String identificacion);

    ProveedorTO modificarProveedor(ProveedorTO proveedor);
    List<ProveedorTO> buscarTodosProveedores();


     ProveedorTO buscarPorNombre(String nombreEmpresa);

    List<ProveedorTO> listarPorNombre(String nombreEmpresa);

    ProveedorTO buscarPorIdentificacion(String identificacion);

    void actualizarProveedor(Proveedor proveedor);

    ProveedorTO buscarProvPorCodBarrasRepu(String codBarras);

    List<String> listarPorNombreEmpresa();

    List<ProveedorTO> buscarPorNombreOIdentifi(String nombreOIdenti);

}
