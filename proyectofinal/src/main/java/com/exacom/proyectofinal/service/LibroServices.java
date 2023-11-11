package com.exacom.proyectofinal.service;

import com.exacom.proyectofinal.domain.LibroDTO;
import com.exacom.proyectofinal.exceptions.CoreException;

import java.util.List;

public interface LibroServices {
    LibroDTO finById(Long id) throws CoreException;

    List <LibroDTO> findAll();
    String save (LibroDTO rolDTO) throws CoreException;
    String update (LibroDTO rolDTO) throws CoreException;
    String delete (Long id);
}
