package com.exacom.proyectofinal.Util;

import com.exacom.proyectofinal.exceptions.CoreException;
import org.springframework.http.HttpStatus;

public class Util {

    public static CoreException getCoreException(String messageUser, String developMessage, HttpStatus status){
        return CoreException.builder()
                .userMessage(messageUser)
                .developMessage(developMessage)
                .errorCode(status.value())
                .erroType(status.name())
                .build();
    }
}
