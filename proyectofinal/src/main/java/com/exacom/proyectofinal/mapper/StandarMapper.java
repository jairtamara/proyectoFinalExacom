package com.exacom.proyectofinal.mapper;

public interface StandarMapper <T , R>{
    /**
     * Metodo para transformar una entidad a un DTO
     * @param dto
     * @return
     */
    T toEntity(R dto);

    R toDTO(T Entity);


}
