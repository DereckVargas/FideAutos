package com.Fideautos.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
}
