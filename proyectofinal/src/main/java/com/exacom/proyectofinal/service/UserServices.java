package com.exacom.proyectofinal.service;

import com.exacom.proyectofinal.domain.UserDTO;
import com.exacom.proyectofinal.exceptions.CoreException;

import java.util.List;

public interface UserServices {

    UserDTO findById(long id) throws CoreException;

    UserDTO findByEmail(String email) throws CoreException;
    List<UserDTO> findAll();

    String save(UserDTO userDTO) throws CoreException;
    String update(UserDTO userDTO) throws CoreException;
    String delete(UserDTO userDTO);


    String delete(long id);
}
