package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domain.AutorDTO;
import com.exacom.proyectofinal.domain.RolDTO;
import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Rol;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper implements StandarMapper<Autor, AutorDTO> {

    @Override
    public Autor toEntity(AutorDTO dto) {
        return Autor.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(dto.getCountry())
                .build();
    }

    @Override
    public AutorDTO toDTO(Autor entity) {
        return AutorDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(entity.getCountry())
                .build();
    }
}
