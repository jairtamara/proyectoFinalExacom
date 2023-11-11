package com.exacom.proyectofinal.model;

import com.exacom.proyectofinal.model.pk.StockPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name="stock")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @EmbeddedId
    private StockPK id;

    private  Integer cantidad;

}
