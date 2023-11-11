package com.exacom.proyectofinal.exceptions;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoreException extends Exception {

    private String userMessage;
    private String developMessage;
    private  int errorCode;
    private String erroType;

}
