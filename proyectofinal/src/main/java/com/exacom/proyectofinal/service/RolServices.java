package com.exacom.proyectofinal.service;

import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.exceptions.CoreException;

import java.util.List;

public interface RolServices {
    RolDTO finById(Long id) throws CoreException;

    List <RolDTO> findAll();
    String save (RolDTO rolDTO) throws CoreException;
    String update (RolDTO rolDTO) throws CoreException;
    String delete (Long rolDTO);
}
