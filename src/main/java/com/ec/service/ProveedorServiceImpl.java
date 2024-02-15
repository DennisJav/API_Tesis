package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.repository.IProveedorRepo;
import com.ec.service.dto.ProveedorTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepo iProveedorRepo;

    @Override
    public ProveedorTO crearProovedor(ProveedorTO proveedor) {
        Proveedor prov =  Proveedor.builder()
                .empresa(proveedor.getNombreEmpresa())
                .telefono(proveedor.getTelefono())
                .correo(proveedor.getCorreo())
                .origen(proveedor.getOrigen())
                .fechaRegistro(LocalDateTime.now())
                .build();
        this.iProveedorRepo.crearProveedor(prov);
        return proveedor;
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
    public Integer eliminarProveedorPorNombre(String nombreEmpresa) {
        return this.iProveedorRepo.eliminarProveedorPorNombre(nombreEmpresa);
    }

    @Override
    public ProveedorTO modificarProveedor(ProveedorTO proveedor) {
        Proveedor prov = this.iProveedorRepo.buscarPorNombre(proveedor.getNombreEmpresa());
        prov.setCorreo(proveedor.getCorreo());
        prov.setEmpresa(proveedor.getNombreEmpresa());
        prov.setTelefono(proveedor.getTelefono());
        prov.setFechaRegistro(proveedor.getFechaRegistro());
        prov.setOrigen(proveedor.getOrigen());

        this.iProveedorRepo.actualizarProveedor(prov);
        return proveedor;
    }

    @Override
    public List<ProveedorTO> buscarTodosProveedores() {
        return this.iProveedorRepo.buscarTodosProveedor()
                .parallelStream()
                .map(proveedor -> this.convertirAProveedorTO(proveedor))
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorTO buscarPorNombre(String nombreEmpresa) {
        return this.convertirAProveedorTO(this.iProveedorRepo.buscarPorNombre(nombreEmpresa));
    }

    @Override
    public List<ProveedorTO> listarPorNombre(String nombreEmpresa) {
        List<Proveedor> list = this.iProveedorRepo.buscarPorNombreLista(nombreEmpresa);
        return  list.parallelStream()
                .map(prov->convertirAProveedorTO(prov))
                .collect(Collectors.toList());
    }


    private ProveedorTO convertirAProveedorTO(Proveedor proveedor){
        ProveedorTO prov = ProveedorTO.builder()
                .fechaRegistro(proveedor.getFechaRegistro())
                .nombreEmpresa(proveedor.getEmpresa())
                .correo(proveedor.getCorreo())
                .origen(proveedor.getOrigen())
                .telefono(proveedor.getTelefono())
                .build();
                return prov;
    }
}
