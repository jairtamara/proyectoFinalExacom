package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByIsbn(String isbn);
    //int countByIsbnAndId(String isbn , int id);
}
