package com.exacom.proyectofinal.exceptions;

import com.exacom.proyectofinal.domain.ExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <List<String>>handleMethoArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("Ha ocurrido un error inisperado");
        var list =  new ArrayList<String>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            list.add("La propiedad "+fieldError.getField() + " "+  fieldError.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ExceptionDTO> handleCoreException(CoreException e){
        log.error("ha ocurrido un error ", e);
        var error = ExceptionDTO.builder()
                .userMessage(e.getUserMessage())
                .developMesssage(e.getDevelopMessage())
                .errorCode(e.getErrorCode())
                .erroType(e.getErroType())
                .build();
        return ResponseEntity.status(e.getErrorCode()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ExceptionDTO handleException(Exception e){
        log.error("ha ocurrido un error ", e);
        var  error = ExceptionDTO.builder()
                        .userMessage("Ha ocurrido un error ")
                        .developMesssage(e.getMessage())
                        .errorCode(500)
                        .erroType("Error interno")
                        .build();
        return ResponseEntity.status(500).body(error).getBody();


    }
}
