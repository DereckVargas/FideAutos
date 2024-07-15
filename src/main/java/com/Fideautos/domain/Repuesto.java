package com.Fideautos.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
}
