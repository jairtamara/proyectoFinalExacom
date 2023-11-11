package com.exacom.proyectofinal.mapper;

import com.exacom.proyectofinal.domain.LibroDTO;
import com.exacom.proyectofinal.model.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LibroMapper implements StandarMapper<Libro, LibroDTO> {

    private final AutorMapper autorMapper;
    @Override
    public Libro toEntity(LibroDTO dto) {
        return Libro.builder()
                .id(dto.getId())
                .tittle(dto.getTittle())
                .autor(autorMapper.toEntity(dto.getAutor()))
                .editorial(dto.getEditorial())
                .gender(dto.getGender())
                .isbn(dto.getIsbn())
                .build();
    }

    @Override
    public LibroDTO toDTO(Libro entity) {
        return LibroDTO.builder()
                .id(entity.getId())
                .tittle(entity.getTittle())
                .autor(autorMapper.toDTO(entity.getAutor()))
                .editorial(entity.getEditorial())
                .gender(entity.getGender())
                .isbn(entity.getIsbn())
                .build();
    }
}
