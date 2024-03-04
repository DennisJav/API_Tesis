package com.ec.controller;

import com.ec.service.IProveedorService;
import com.ec.service.IRepuestoService;
import com.ec.service.dto.ProveedorTO;
import com.ec.service.dto.RepuestoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/repuestos")
public class RepuestoController {

    @Autowired
    private IRepuestoService repuestoService;

    @Autowired
    private IProveedorService proveedorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity crearRepuestos(@RequestBody List<RepuestoTO> repuestos, @RequestParam String nomEmpresaProveedor) {
        System.out.println("Legando al controlador, param: "+nomEmpresaProveedor);
        repuestoService.crearRepuesto(repuestos, nomEmpresaProveedor);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarRepuesto(@RequestBody RepuestoTO repuesto){

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("succesEdit","Repuesto Editado correctamente");
          return new ResponseEntity<>(this.repuestoService.modificarRepuesto(repuesto),cabecera,OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RepuestoTO>> listarRepuestos(){
        List<RepuestoTO> lista = this.repuestoService.buscarTodosRepuestos();
        for (var r:lista) {
            Link myLink = linkTo(methodOn(ProveedorController.class).buscarPorCodBarras(r.getCodBarras())).withRel("proveedor");
                  r.add(myLink);
        }
        return new ResponseEntity<>(lista,null,OK);
    }

    @GetMapping(path = "/proveedores/{cB}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedorTO> buscarPorCodBRepu(@PathVariable(name="cB")String cB){
        ProveedorTO prov = this.proveedorService.buscarProvPorCodBarrasRepu(cB);
        return new ResponseEntity<>(prov,null,OK);
    }

    @GetMapping(path="/{codigoBarras}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> verRepuestoPorCodBarras(@PathVariable String codigoBarras) {
       // System.out.println("llegando: "+codigoBarras);
        RepuestoTO repuesto = this.repuestoService.buscarPorCodBarras(codigoBarras);
        if (repuesto != null) {
            return ResponseEntity.ok(repuesto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/buscarCBN",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RepuestoTO>> buscarCodBarONombre(@RequestParam String codBarraONombre){
        return new ResponseEntity<>(this.repuestoService.buscarPorCodBarraONombre(codBarraONombre),null,OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarPorCodBarras(@RequestParam String codBarras){
        Integer resp = this.repuestoService.eliminarRepuestoPorCodBarras(codBarras);
        HttpHeaders headers = new HttpHeaders();
        headers.set("mensaje1","mensaje1");
        headers.add("mensaje2","mensaje2");

        if(resp!=1){
            headers.set("fallo","No se pudeo eliminar, pongase en contacto con el administrador");
            return new ResponseEntity<>(resp,headers,OK);
        }
        headers.set("exito","Item eliminado correctamente");

        for (var entry : headers.entrySet()) {
            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
        }

        return  new ResponseEntity<>(resp,headers,OK);
    }
}
