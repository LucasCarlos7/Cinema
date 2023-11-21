package com.api.cinema.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "analise")
public class AnaliseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String textoAnalise;
    private Integer nota;
    
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private FilmeEntity filme;
}
