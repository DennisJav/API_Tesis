package com.ec.service;

import com.ec.entity.Usuario;
import com.ec.repository.IRequerimientoRepo;
import com.ec.repository.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequerimientoServiceImpl implements IRequerimientoService{

    @Autowired
    private IRequerimientoRepo iRequerimientoRepo;
    @Autowired
    private IUsuarioRepo iUsuarioRepo;


    @Override
    public void crearRequerimiento(String cedula, String numTecnico) {

        Usuario cliente=this.iUsuarioRepo.buscarPorCedula(cedula);
        Usuario tecnico=this.iUsuarioRepo.buscarPorIdentificadorTecnico(numTecnico);




    }
}
