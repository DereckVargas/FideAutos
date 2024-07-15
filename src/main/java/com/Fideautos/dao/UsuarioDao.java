package com.Fideautos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fideautos.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByNombreusuario(String nombreusuario);
}
