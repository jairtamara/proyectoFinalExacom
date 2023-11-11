package com.exacom.proyectofinal.service;

import com.exacom.proyectofinal.domain.StockDTO;

import java.util.List;

public interface StockServices {
        StockDTO findByID(Long autorId , Long libroId);
        List<StockDTO> findAll();
        List<StockDTO> findAllByAutorId();
        List<StockDTO>findAllByLibroId();

    List<StockDTO> findAllByAutorId(Long autorId);

    List<StockDTO> findAllByLibroId(Long libroId);

    StockDTO save(StockDTO stockDTO);

        StockDTO update (StockDTO stockDTO);
        void delete (Long autorId, Long libroId);




        }
