package com.Fideautos.controller;

import com.Fideautos.dao.CarroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Fideautos.domain.Favorito;
import com.Fideautos.domain.Usuario;
import com.Fideautos.dao.FavoritoDao;
import com.Fideautos.dao.UsuarioDao;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/favoritos")
public class FavoritoController {
     @Autowired
    private FavoritoDao favoritodao;

    @Autowired
    private UsuarioDao usuariodao;
    
    @Autowired
    private CarroDao carrodao;
    
    @GetMapping
    public String listFavorites(Principal principal, Model model) {
        Usuario usuario = usuariodao.findByNombreusuario(principal.getName());
        List<Favorito> favoritos = favoritodao.findByNombreusuario(usuario.getId());
        model.addAttribute("favoritos", favoritos);
        return "listafavorito";
    }

    @GetMapping("/añadir/{id}")
    public String añadirFavorito(@PathVariable Long id, Principal principal) {
        Usuario usuario = usuariodao.findByNombreusuario(principal.getName());
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setCarro(carrodao.findById(id).orElse(null));
        favoritodao.save(favorito);
        return "redirect:/carros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFavorito(@PathVariable Long id) {
        favoritodao.deleteById(id);
        return "redirect:/favoritos";
    }
}
