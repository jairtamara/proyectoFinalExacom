package com.exacom.proyectofinal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private  String userMessage;
    private  String developMesssage;
    private  int errorCode;
    private String erroType;

}
