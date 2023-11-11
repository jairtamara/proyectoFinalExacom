package com.exacom.proyectofinal.model;


import com.exacom.proyectofinal.Util.CountryEnum;
import com.exacom.proyectofinal.Util.GenderBookEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Libros")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 128)
    private String tittle ;
    @Column(nullable = false,length = 64)
    private GenderBookEnum gender;
    @Column(nullable = false,length = 128)
    private String editorial;
    @ManyToOne
    private Autor autor;
    @Column(nullable = false,length = 64, unique = true)
    private String isbn;


}
