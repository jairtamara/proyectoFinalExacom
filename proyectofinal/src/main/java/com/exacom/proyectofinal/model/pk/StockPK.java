package com.exacom.proyectofinal.model.pk;

import com.exacom.proyectofinal.model.Autor;
import com.exacom.proyectofinal.model.Libro;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockPK {

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Libro libro;



}
