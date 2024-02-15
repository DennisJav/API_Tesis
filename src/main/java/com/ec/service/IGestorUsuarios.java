package com.ec.service;

import com.ec.entity.Usuario;
import com.ec.service.dto.UsuarioTO;

public interface IGestorUsuarios {

    void crearUsuario(UsuarioTO usuario);
    void actualizarUsuario(UsuarioTO usuario);

}
