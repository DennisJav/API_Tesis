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
            return new ResponseEntity<>(this.proveedorService.crearProovedor(proveedor),cabecera, OK);
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
    public ResponseEntity<Integer> eliminarPorNombre(@PathVariable String nombreEmpresa){

      Integer val=  this.proveedorService.eliminarProveedorPorNombre(nombreEmpresa);

      if (val!=1){
          return new ResponseEntity<>(val,null,HttpStatus.NO_CONTENT);
      }
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("detailMessage","Proveedor eliminado exitosamente");
      return new ResponseEntity<>(val,cabecera,OK);
    }


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
