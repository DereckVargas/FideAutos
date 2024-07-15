package com.Fideautos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fideautos.domain.Carro;
import java.util.List;

public interface CarroDao extends JpaRepository<Carro, Long>{
    List<Carro> findByMarcaAndAñoAndPrecioMenosQueIgual(String marca, int año, double precio);
}
