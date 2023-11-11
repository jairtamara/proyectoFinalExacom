package com.exacom.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exacom.proyectofinal.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
   boolean existsByUsername(String username);
//@Query("SELECT COUNT(u) FROM User u WHERE u.email= : email AND u.id <> :id")
   int countByEmail( String email);
   //int countByEmail(@Param("email") String email, @Param("id") Long id);
   // @Query("SELECT COUNT(u) FROM User u WHERE u.email= : username AND u.id <> :id")
    int countByUsername(String username);
    // int countByUsername(@Param("username") String username, @Param("id") Long id  );

}

