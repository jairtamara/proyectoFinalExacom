package com.exacom.proyectofinal.controller;

import com.exacom.proyectofinal.domain.AutorDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.service.AutorServices;
import com.exacom.proyectofinal.validation.CoreValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor/v1/api")
@RequiredArgsConstructor
public class AutorControler {
    private final AutorServices autorServices;
    //private final  AutorDTO autorDTO;

    @GetMapping("/findAll")
    public List<AutorDTO> finAll() {
        return autorServices.findAll();
    }

    @GetMapping("/findAll/{id}")
    public AutorDTO finByid(@PathVariable long id) throws CoreException {
        return autorServices.finById(id);
    }

    @PutMapping("/create")
        public String create(@Validated(CoreValidation.Create.class) @RequestBody  AutorDTO autorDTO)
            throws CoreException {
        return autorServices.save(autorDTO);
    }

    @PostMapping("/update")
    public String update(@Validated(CoreValidation.Update.class) @RequestBody  AutorDTO autorDTO)
            throws CoreException {
        return autorServices.update(autorDTO);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return autorServices.delete(id);
    }







}