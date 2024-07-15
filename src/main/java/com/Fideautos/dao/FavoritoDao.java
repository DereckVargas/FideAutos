package com.Fideautos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fideautos.domain.Favorito;
import java.util.List;

public interface FavoritoDao extends JpaRepository<Favorito, Long>{
    List<Favorito> findByNombreusuario(Long nombreusuario);
}
