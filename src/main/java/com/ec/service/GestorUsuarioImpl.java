package com.ec.service;

import com.ec.entity.Usuario;
import com.ec.repository.IUsuarioRepo;
import com.ec.service.dto.UsuarioTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorUsuarioImpl implements IGestorUsuarios{


    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    @Transactional
    public void crearUsuario(UsuarioTO usuario) {

        Usuario user=new Usuario();

        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setCedula(usuario.getCedula());
        user.setTelefono(usuario.getTelefono());
        user.setDireccion(usuario.getDireccion());
        user.setTipo(usuario.getTipo());
        user.setContrasena(usuario.getPassword());

        if(usuario.getTipo().equals("tecnico")){
            user.setIdentificador(usuario.getCedula().substring(usuario.getCedula().length()-3).concat(usuario.getApellido()));
        }

        this.iUsuarioRepo.crearUsuario(user);

    }

    @Override
    @Transactional
    public void actualizarUsuario(UsuarioTO usuario) {
        Usuario user = this.usuarioService.buscarPorCedula(usuario.getCedula());

        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setCedula(usuario.getCedula());
        user.setTelefono(usuario.getTelefono());
        user.setEmail(usuario.getEmail());
        user.setDireccion(usuario.getDireccion());

        this.iUsuarioRepo.actualizarUsuario(user);
    }





}

