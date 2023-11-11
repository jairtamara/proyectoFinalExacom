package com.exacom.proyectofinal.mapper;


import com.exacom.proyectofinal.domain.StockDTO;
import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import com.exacom.proyectofinal.model.Stock;
import com.exacom.proyectofinal.model.pk.StockPK;
import org.springframework.stereotype.Component;

@Component
public class StockMapper implements StandarMapper<Stock, StockDTO> {

    @Override
    public Stock toEntity(StockDTO dto) {
        var  id = StockPK.builder();
                 StockPK.builder()
                .autor(Autor.builder().id(dto.getAutorId()).build())
                 .libro(Libro.builder().id(Long.parseLong(dto.getLibroId())).build())
                .build();
                 return Stock.builder()
                         .id(id.build())
                         .cantidad(dto.getCantidad())

                         .build();
    }

    @Override
    public StockDTO toDTO(Stock entity) {
        return StockDTO.builder()
                .autorId(entity.getId().getAutor().getId())
                .autorName(entity.getId().getAutor().getName())
                .libroId(entity.getId().getLibro().getTittle())
                .libroName(entity.getId().getLibro().getTittle())
                .cantidad(entity.getCantidad())
                .build();
    }
}
