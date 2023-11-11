package com.exacom.proyectofinal.model;


import com.exacom.proyectofinal.Util.CountryEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="autores")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
   // @Enumerated
    private CountryEnum country;
   @Column(nullable = false,length = 64)
    private String name;
}
