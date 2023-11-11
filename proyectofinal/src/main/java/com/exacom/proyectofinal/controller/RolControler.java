package com.exacom.proyectofinal.controller;

import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.service.RolServices;
import com.exacom.proyectofinal.validation.CoreValidation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol/v1/api")
@RequiredArgsConstructor
public class RolControler {
    private final RolServices rolServices;
    //private final  RolDTO rolDTO;

    @GetMapping("/findAll")
    public List<RolDTO> finAll() {
        return rolServices.findAll();
    }

    @GetMapping("/findAll/{id}")
    public RolDTO finByid(@PathVariable long id) throws CoreException {
        return rolServices.finById(id);
    }

    @PutMapping("/create")
        public String create(@Validated(CoreValidation.Create.class) @RequestBody  RolDTO rolDTO)
            throws CoreException {
        return rolServices.save(rolDTO);
    }

    @PostMapping("/update" )
    public String update(@Validated(CoreValidation.Update.class) @RequestBody  RolDTO rolDTO)
            throws CoreException {
        return rolServices.update(rolDTO);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return rolServices.delete(id);
    }







}