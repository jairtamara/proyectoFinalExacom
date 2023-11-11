package com.exacom.proyectofinal.repository;

import com.exacom.proyectofinal.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByName(String name);
  //  int countByname(long id);

}
