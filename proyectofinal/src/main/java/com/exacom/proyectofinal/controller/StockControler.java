package com.exacom.proyectofinal.controller;

import com.exacom.proyectofinal.domain.StockDTO;
import com.exacom.proyectofinal.exceptions.CoreException;
import com.exacom.proyectofinal.service.StockServices;
import com.exacom.proyectofinal.validation.CoreValidation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock/v1/api")
@RequiredArgsConstructor
public class StockControler {
    private final StockServices stockServices;
    //private final  StockDTO stockDTO;

    @GetMapping("/findAll")
    public List<StockDTO> finAll() {
        return stockServices.findAll();
    }

    @GetMapping("/find/{autorId}/{libroId}")
    public StockDTO finByid(@PathVariable("autorId") long autorid,@PathVariable("libroid") long libroid)
            throws CoreException {
        return stockServices.findByID(autorid,libroid);
    }

    @GetMapping("/findByAutorId/{autorId}")
    public  List<StockDTO> finByidAutorId(@PathVariable("autorId") long autorid)
            throws CoreException {
        return stockServices.findAllByAutorId(autorid);
    }

    @GetMapping("/findByLibroId/{LibroId}")
    public  List<StockDTO> finByidLibroId(@PathVariable("libroId") long librod)
            throws CoreException {
        return stockServices.findAllByAutorId(librod);
    }


    @PutMapping("/create")
        public StockDTO create(@Validated(CoreValidation.Create.class) @RequestBody  StockDTO stockDTO)
            throws CoreException {
        return stockServices.save(stockDTO);
    }

    @PostMapping("/update")
    public StockDTO update(@Valid @RequestBody  StockDTO stockDTO)
            throws CoreException {
        return stockServices.update(stockDTO);
    }



    @DeleteMapping("/delete/{autorId}/{libroId}")
    public String delete(@PathVariable("autorId") long autorid,@PathVariable("libroid") long libroid){
        stockServices.delete(autorid,libroid);
        return "Se elimino el registro solicitado";
    }







}