package com.exacom.proyectofinal.controller;

import com.exacom.proyectofinal.domain.LibroDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.service.LibroServices;
import com.exacom.proyectofinal.validation.CoreValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro/v1/api")
@RequiredArgsConstructor
public class LibroControler {
    private final LibroServices libroServices;
    //private final  LibroDTO libroDTO;

    @GetMapping("/findAll")
    public List<LibroDTO> finAll() {
        return libroServices.findAll();
    }

    @GetMapping("/findAll/{id}")
    public LibroDTO finByid(@PathVariable long id) throws CoreException {
        return libroServices.finById(id);
    }

    @PutMapping("/create")
        public String create(@Validated(CoreValidation.Create.class) @RequestBody  LibroDTO libroDTO)
            throws CoreException {
        return libroServices.save(libroDTO);
    }

    @PostMapping("/update")
    public String update(@Validated(CoreValidation.Update.class) @RequestBody  LibroDTO libroDTO)
            throws CoreException {
        return libroServices.update(libroDTO);
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return libroServices.delete(id);
    }







}