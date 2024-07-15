package com.Fideautos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Fideautos.domain.Carro;
import com.Fideautos.domain.Usuario;
import com.Fideautos.dao.CarroDao;
import com.Fideautos.dao.UsuarioDao;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroDao carrodao;

    @Autowired
    private UsuarioDao usuariodao;

    @GetMapping
    public String listaCarros(Model model) {
        model.addAttribute("carros", carrodao.findAll());
        return "listacarro";
    }

    @GetMapping("/añadir")
    public String añadirCarros(Model model) {
        model.addAttribute("carro", new Carro());
        return "formulariocarro";
    }

    @PostMapping
    public String guardarCarro(@ModelAttribute Carro carro, Principal principal) {
        Usuario usuario = usuariodao.findByNombreusuario(principal.getName());
        carro.setUsuario(usuario);
        carrodao.save(carro);
        return "redirect:/carros";
    }

    @GetMapping("/ediart/{id}")
    public String editarCarro(@PathVariable Long id, Model model) {
        Carro carro = carrodao.findById(id).orElse(null);
        model.addAttribute("carro", carro);
        return "listacarro";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCarro(@PathVariable Long id) {
        carrodao.deleteById(id);
        return "redirect:/carros";
    }

    @GetMapping("/buscar")
    public String buscarCarros(@RequestParam String marca, @RequestParam int año, @RequestParam double precio, Model model) {
        List<Carro> carros = carrodao.findByMarcaAndAñoAndPrecioMenosQueIgual(marca, año, precio);
        model.addAttribute("cars", carros);
        return "listacarro";
    }
}
