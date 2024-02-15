package com.ec.service;

import com.ec.entity.Usuario;
import com.ec.repository.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorUsuarioImpl implements IGestorUsuarios{


    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @Override
    public void crearUsuario(String nombre, String apellido, String email, String cedula, String telefono, String direccion, String tipo) {

        Usuario user=new Usuario();

        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setEmail(email);
        user.setCedula(cedula);
        user.setTelefono(telefono);
        user.setDireccion(direccion);
        user.setTipo(tipo);
        user.setContrasena(cedula);

        if(tipo.equals("tecnico")){
            user.setIdentificador(cedula.substring(cedula.length()-3).concat(apellido));
        }

        this.iUsuarioRepo.crearUsuario(user);

    }

    @Override
    public void actualizarUsuario(Integer id, String nombre, String apellido, String cedula,String telefono, String email, String direccion) {

        Usuario user = this.iUsuarioRepo.buscarUsuario(id);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCedula(cedula);
        user.setTelefono(telefono);
        user.setEmail(email);
        user.setDireccion(direccion);

        this.iUsuarioRepo.actualizarUsuario(user);
    }





}

