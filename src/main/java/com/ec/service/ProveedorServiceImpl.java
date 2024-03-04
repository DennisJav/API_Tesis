package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.repository.IProveedorRepo;
import com.ec.service.dto.ProveedorTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepo iProveedorRepo;

    @Override
    @Transactional
    public ProveedorTO crearProovedor(ProveedorTO proveedor) {
        Proveedor prov =  Proveedor.builder()
                .empresa(proveedor.getNombreEmpresa())
                .tipoIdentificacion(proveedor.getTipoIdentificacion())
                .identificacion(proveedor.getIdentificacion())
                .telefono(proveedor.getTelefono())
                .correo(proveedor.getCorreo())
                .origen(proveedor.getOrigen())
                .fechaRegistro(LocalDateTime.now())
                .build();
        try{
            System.out.println("prov antes de enviarle al repo"+prov.toString());
            this.iProveedorRepo.crearProveedor(prov);
            return proveedor;
        }catch(DataIntegrityViolationException e){
            throw new IllegalArgumentException("Ya existe un proveedor con la identificación: " + proveedor.getIdentificacion());
        }
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Proveedor buscarProveedor(Integer id) {
        return this.iProveedorRepo.buscarProveedor(id);
    }

    @Override
    @Transactional
    public void eliminarProveedor(Integer id) {
        this.iProveedorRepo.borrarProveedor(id);
    }

    @Override
    public Integer eliminarProveedorPorNombre(String nombreEmpresa) {
        return this.iProveedorRepo.eliminarProveedorPorNombre(nombreEmpresa);
    }

    @Override
    @Transactional
    public Integer eliminarProveedorPorIdentificacion(String identificacion) {
        Proveedor p = this.iProveedorRepo.buscarPorIdentificacion(identificacion);
        return this.iProveedorRepo.eliminarProveedorPorIdentificacion(p);
    }

    @Override
    @Transactional
    public ProveedorTO modificarProveedor(ProveedorTO proveedor) {
        Proveedor prov = this.iProveedorRepo.buscarPorIdentificacion(proveedor.getIdentificacion());
        proveedor.setId(prov.getId());
        System.out.println("prov para mod: "+proveedor.toString());
        this.iProveedorRepo.actualizarProveedor(this.convertirAProveedor(proveedor));
        return proveedor;
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<ProveedorTO> buscarTodosProveedores() {
        return this.iProveedorRepo.buscarTodosProveedor()
                .parallelStream()
                .map(proveedor -> this.convertirAProveedorTO(proveedor))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ProveedorTO buscarPorNombre(String nombreEmpresa) {
        return this.convertirAProveedorTO(this.iProveedorRepo.buscarPorNombre(nombreEmpresa));
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<ProveedorTO> listarPorNombre(String nombreEmpresa) {
        List<Proveedor> list = this.iProveedorRepo.buscarPorNombreLista(nombreEmpresa);
        return  list.parallelStream()
                .map(prov->convertirAProveedorTO(prov))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ProveedorTO buscarPorIdentificacion(String identificacion) {
        return this.convertirAProveedorTO(this.iProveedorRepo.buscarPorIdentificacion(identificacion));
    }

    @Override
    @Transactional
    public void actualizarProveedor(Proveedor proveedor) {
        this.iProveedorRepo.actualizarProveedor(proveedor);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ProveedorTO buscarProvPorCodBarrasRepu(String codBarras) {
        return convtoProveedorTOHateoas(this.iProveedorRepo.proveedorPorCodBarraRepu(codBarras));
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<String> listarPorNombreEmpresa() {
        return this.iProveedorRepo.listarPorNombre().parallelStream().sorted((x,y)->x.compareTo(y)).collect(Collectors.toList());
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<ProveedorTO> buscarPorNombreOIdentifi(String nombreOIdenti) {
        return this.iProveedorRepo.buscarPorNombreOIdentifi(nombreOIdenti).parallelStream()
                .map(p->convertirAProveedorTO(p)).collect(Collectors.toList());
    }


    private ProveedorTO convertirAProveedorTO(Proveedor proveedor){
        ProveedorTO prov = ProveedorTO.builder()
                .fechaRegistro(proveedor.getFechaRegistro())
                .nombreEmpresa(proveedor.getEmpresa())
                .tipoIdentificacion(proveedor.getTipoIdentificacion())
                .identificacion(proveedor.getIdentificacion())
                .correo(proveedor.getCorreo())
                .origen(proveedor.getOrigen())
                .telefono(proveedor.getTelefono())
                .build();
                return prov;
    }

    private ProveedorTO convtoProveedorTOHateoas(Proveedor proveedor){
        return ProveedorTO.builder()
                .tipoIdentificacion(proveedor.getTipoIdentificacion())
                .identificacion(proveedor.getIdentificacion())
                .nombreEmpresa(proveedor.getEmpresa())
                .correo(proveedor.getCorreo())
                .telefono(proveedor.getTelefono())
                .fechaRegistro(proveedor.getFechaRegistro())
                .origen(proveedor.getOrigen())
                .build();
    }

    Proveedor convertirAProveedor(ProveedorTO proveedor){
        return Proveedor.builder()
                .id(proveedor.getId())
                .tipoIdentificacion(proveedor.getTipoIdentificacion())
                .identificacion(proveedor.getIdentificacion())
                .correo(proveedor.getCorreo())
                .empresa(proveedor.getNombreEmpresa())
                .origen(proveedor.getOrigen())
                .telefono(proveedor.getTelefono())
                .fechaRegistro(proveedor.getFechaRegistro())
                .build();
    }
}
