package com.Fideautos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fideautos.domain.Repuesto;
import java.util.List;

public interface RepuestoDao extends JpaRepository<Repuesto, Long> {
    List<Repuesto>findByNombreContaining(String nombre);
}
