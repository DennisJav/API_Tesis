package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.entity.Repuesto;
import com.ec.service.dto.RepuestoTO;

import java.util.List;

public interface IRepuestoService {
    Repuesto crearRepuesto(Repuesto repuesto);
    Repuesto buscarRepuesto(Integer id);
    RepuestoTO modificarRepuesto(RepuestoTO repuesto);

    Integer eliminarRepuestoPorCodBarras(String codBarras);

    List<RepuestoTO> buscarTodosRepuestos();

    void crearRepuesto(List<RepuestoTO>repuestosList,String nomEmpresaProveedor);

    RepuestoTO buscarPorCodBarras(String codBarras);

    List<RepuestoTO> buscarPorCodBarraONombre(String codBarrasONombre);

}
