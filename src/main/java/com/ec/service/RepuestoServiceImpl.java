package com.ec.service;

import com.ec.entity.Proveedor;
import com.ec.entity.Repuesto;
import com.ec.repository.IProveedorRepo;
import com.ec.repository.IRepuestoRepo;
import com.ec.service.dto.RepuestoTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepuestoServiceImpl implements  IRepuestoService{

    @Autowired
    private IRepuestoRepo iRepuestoRepo;

    @Autowired
    private IProveedorRepo proveedorRepo;

    @Override
    @Transactional
    public Repuesto crearRepuesto(Repuesto repuesto) {
       return this.iRepuestoRepo.crearRepuesto(repuesto);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Repuesto buscarRepuesto(Integer id) {
        return this.iRepuestoRepo.buscarRepuesto(id);
    }

    @Override
    @Transactional
    public RepuestoTO modificarRepuesto(RepuestoTO repuesto) {
        Repuesto rAux = this.iRepuestoRepo.buscarPorCodBarras(repuesto.getCodBarras());
        repuesto.setId(rAux.getId());
        repuesto.setProveedor(rAux.getProveedor());
        repuesto.setSubTotal(repuesto.getPrecio().multiply(new BigDecimal(repuesto.getStock())));
        this.iRepuestoRepo.actualizarRepuesto(convertirARepuesto(repuesto));
        return repuesto;
    }

    @Override
    @Transactional
    public Integer eliminarRepuestoPorCodBarras(String codBarras) {
        return this.iRepuestoRepo.borrarRepuesto(codBarras);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<RepuestoTO> buscarTodosRepuestos() {
        List<Repuesto> l1 =this.iRepuestoRepo.buscarTodosRepustos();
        return l1.parallelStream().map(r->{
            return RepuestoTO.builder()
                    .precio(r.getPrecio())
                    .nombre(r.getNombre())
                    .codBarras(r.getCodBarras())
                    .estado(r.getEstado())
                    .tipo(r.getTipo())
                    .stock(r.getStock())
                    .proveedor(r.getProveedor())
                    .nombreEmpresa(r.getProveedor().getEmpresa())
                    .identificacionEmpresa(r.getProveedor().getIdentificacion())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void crearRepuesto(List<RepuestoTO> repuestosList,String nomEmpresaProveedor) {
        Proveedor p = this.proveedorRepo.buscarPorNombre(nomEmpresaProveedor);

        for (var r:repuestosList) {
            r.setProveedor(p);
            r.setSubTotal(r.getPrecio().multiply(new BigDecimal(r.getStock())));
            System.out.println(r.toString());
            this.crearRepuesto(convertirARepuesto(r));
        }
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public RepuestoTO buscarPorCodBarras(String codBarras) {
        Repuesto r = this.iRepuestoRepo.buscarPorCodBarras(codBarras);
        System.out.println(convertirToRepuestoTO(r).toString());
        return this.convertirToRepuestoTO(this.iRepuestoRepo.buscarPorCodBarras(codBarras));
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<RepuestoTO> buscarPorCodBarraONombre(String codBarrasONombre) {
        return this.iRepuestoRepo.buscarPorCodBarraNombre(codBarrasONombre)
                .parallelStream()
                .map(r->convertirToRepuestoTO(r))
                .collect(Collectors.toList());
    }

    private Repuesto convertirARepuesto(RepuestoTO repuestoTO){
        return Repuesto.builder()
                .id(repuestoTO.getId())
                .precio(repuestoTO.getPrecio())
                .codBarras(repuestoTO.getCodBarras())
                .estado(repuestoTO.getEstado())
                .nombre(repuestoTO.getNombre())
                .tipo(repuestoTO.getTipo())
                .stock(repuestoTO.getStock())
                .proveedor(repuestoTO.getProveedor())
                .subTotal(repuestoTO.getSubTotal())
                .stock(repuestoTO.getStock())
                .build();
    }

    private RepuestoTO convertirToRepuestoTO(Repuesto repuesto){
        return RepuestoTO.builder()
                .nombre(repuesto.getNombre())
                .identificacionEmpresa(repuesto.getProveedor().getIdentificacion())
                .nombreEmpresa(repuesto.getProveedor().getEmpresa())
                .tipo(repuesto.getTipo())
                .precio(repuesto.getPrecio())
                .codBarras(repuesto.getCodBarras())
                .stock(repuesto.getStock())
                .estado(repuesto.getEstado())
                .build();
    }
}
