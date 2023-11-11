package com.exacom.proyectofinal.controller;

import com.exacom.proyectofinal.domain.UserDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;
    @PutMapping  ("/create")
        public String createUser(@RequestBody UserDTO userDTO ) throws CoreException {
            return userServices.save(userDTO);
    }

    @PostMapping("/update")
    public  String updateUser(@RequestBody UserDTO userDTO) throws CoreException {
        return  userServices.update(userDTO);
    }
    @DeleteMapping("/delete/{id}")
    public  String updateUser(long  id){
        return  userServices.delete(id);
    }


    @GetMapping("/findById/{id}")
    public UserDTO findById(@PathVariable(name = "id") long id) throws CoreException {
        return userServices.findById(id);
    }

    @GetMapping("/findByEmail")
    public UserDTO findByEmail(@PathVariable (name = "email") String email) throws CoreException {
        return userServices.findByEmail(email);
    }
    @GetMapping("/findAll")
    public List<UserDTO> finAll(){
        return userServices.findAll();
    }
}
