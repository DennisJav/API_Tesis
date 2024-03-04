package com.ec.controller;


import com.ec.service.IProveedorService;
import com.ec.service.dto.ProveedorTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin
@RequestMapping(path = "/proveedores")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorTO proveedor){
        try {
            HttpHeaders cabecera = new HttpHeaders();
            cabecera.add("detailMessage","Proveedor guardado exitosamente");
            return new ResponseEntity<>(this.proveedorService.crearProovedor(proveedor),null, OK);
        } catch (Exception e) {
            HttpHeaders cabecera = new HttpHeaders();
            cabecera.add("detailMessage","Ya existe un proveedor la indentificacion ingresada");
            return new ResponseEntity<>(cabecera, BAD_REQUEST);
        }
    }

    @GetMapping(path = "/listar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProveedorTO>> listarProveedores(){
        return new ResponseEntity<>(this.proveedorService.buscarTodosProveedores(),null, OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedorTO> modificarProveedor(@RequestBody ProveedorTO proveedor){
        	HttpHeaders cabecera = new HttpHeaders();
	          cabecera.add("detailMessage","Proveedor modificado exitosamente");

        return new ResponseEntity<>(this.proveedorService.modificarProveedor(proveedor),cabecera, OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminarPorIdentificacion(@RequestParam String identificacion){
      Integer val=  this.proveedorService.eliminarProveedorPorIdentificacion(identificacion);
        HttpHeaders cabecera = new HttpHeaders();

      if (val!=1){
          cabecera.add("errorMessage","No se pudo eliminar proveedor seleccionado");
          return new ResponseEntity<>(0,cabecera,HttpStatus.NO_CONTENT);
      }
        cabecera.add("detailMessage","Proveedor eliminado exitosamente");
      return new ResponseEntity<>(val,cabecera,OK);
    }


    @GetMapping(path = "/{codBarras}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedorTO> buscarPorCodBarras(@PathVariable(name="codBarras") String codBarras){
        return new ResponseEntity<>(this.proveedorService.buscarProvPorCodBarrasRepu(codBarras),null,OK);
    }

    @GetMapping(path = "/empresasNom")
    public ResponseEntity<?> listarEmpresasPorNombre(){
        return new ResponseEntity<>(this.proveedorService.listarPorNombreEmpresa(),null,OK);
    }

    @GetMapping(path = "/listni",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProveedorTO>> listarPorNombreOIdentifi(@RequestParam String nom_identi ){
        return new ResponseEntity<>(this.proveedorService.buscarPorNombreOIdentifi(nom_identi),null,OK);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping(path="/identifi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedorTO> buscarPorIdentificacion(@RequestParam String identificacion){
        return new ResponseEntity<>(this.proveedorService.buscarPorIdentificacion(identificacion),null,OK);
    }
}
