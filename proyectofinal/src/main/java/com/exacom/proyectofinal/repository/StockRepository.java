package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import com.exacom.proyectofinal.model.Stock;
import com.exacom.proyectofinal.model.pk.StockPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockPK> {

    @Query("FROM Stock s WHERE s.id.autor.id = : autorId ")
    List<Stock> findAllByAutor(@Param("autorId") long autorId);
    @Query("FROM Stock s WHERE s.id.libro.id = : libroId ")
    List<Stock> findAllByLibro(@Param("libroId") Long libroId);

}
