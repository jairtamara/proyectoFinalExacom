package com.exacom.proyectofinal.domain;

import com.exacom.proyectofinal.Util.CountryEnum;
import com.exacom.proyectofinal.validation.CoreValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    @NotNull(message = "{NotNull}")
    private Long autorId;
    private String autorName;
    @NotNull(message = "{NotNull}")
    private String libroId;
    private String libroName;
    @NotBlank(message = "{NotBlank}")
    private Integer cantidad;
}
