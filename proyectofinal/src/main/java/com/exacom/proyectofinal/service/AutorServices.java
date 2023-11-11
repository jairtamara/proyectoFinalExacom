package com.exacom.proyectofinal.service;

import com.exacom.proyectofinal.domain.AutorDTO;
import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.exceptions.CoreException;

import java.util.List;

public interface AutorServices {
    AutorDTO finById(Long id) throws CoreException;

    List <AutorDTO> findAll();
    String save (AutorDTO rolDTO) throws CoreException;
    String update (AutorDTO rolDTO) throws CoreException;
    String delete (Long id);
}
