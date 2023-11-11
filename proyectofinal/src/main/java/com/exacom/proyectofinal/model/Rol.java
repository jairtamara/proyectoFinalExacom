package com.exacom.proyectofinal.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="roles")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 32 , nullable = false)
    private String name;
   @ManyToMany(mappedBy = "roles")
   private List<User> users;
}
