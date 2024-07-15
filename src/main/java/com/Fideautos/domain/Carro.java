package com.Fideautos.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private boolean disponibilidad;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    
}



