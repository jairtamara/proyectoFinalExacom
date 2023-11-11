package com.exacom.proyectofinal.service.impl.UserServiceImpl;

import com.exacom.proyectofinal.domain.StockDTO;
import com.exacom.proyectofinal.mapper.StockMapper;
import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import com.exacom.proyectofinal.model.pk.StockPK;
import com.exacom.proyectofinal.repository.StockRepository;
import com.exacom.proyectofinal.service.StockServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class StockServiceImp  implements StockServices {

private final StockRepository stockRepository;
private final StockMapper stockMapper;


    @Override
    public StockDTO findByID(Long autorId, Long libroId) {
        return null;
    }

    @Override
    public List<StockDTO> findAll() {
        var stocks = stockRepository.findAll();

        return stocks.stream().map(stockMapper::toDTO).toList();
    }

    @Override
    public List<StockDTO> findAllByAutorId() {
        return null;
    }

    @Override
    public List<StockDTO> findAllByLibroId() {
        return null;
    }

    @Override
    public List<StockDTO> findAllByAutorId(Long autorId) {
        var stocks = stockRepository.findAllByAutor(autorId);
        return stocks.stream().map(stockMapper::toDTO).toList();
    }

    @Override
    public List<StockDTO> findAllByLibroId(Long libroId) {
        var stocks = stockRepository.findAllByLibro(libroId);
        return stocks.stream().map(stockMapper::toDTO).toList();

    }

    @Override
    public StockDTO save(StockDTO stockDTO) {
        var stock = stockMapper.toEntity(stockDTO);
        return stockMapper.toDTO(stockRepository.save(stock));
    }

    @Override
    public StockDTO update(StockDTO stockDTO) {

        return save(stockDTO);
    }

    @Override
    public void delete(Long autorId, Long libroId) {

    }

 /*   @Override
    public void delete(Long libroId) {
        stockRepository.deleteById(libroId);

    }*/

    private StockPK getStockPK(Long autorId , Long libroId){
        var stockPK = new StockPK();
        return StockPK.builder()
                .autor(Autor.builder().id(autorId).build())
                .libro(Libro.builder().id(libroId).build())
                .build();

    }
}
