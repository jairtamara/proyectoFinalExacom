package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {


}
