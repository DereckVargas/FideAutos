package com.Fideautos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Fideautos.dao.RepuestoDao;
import com.Fideautos.domain.Repuesto;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoDao repuestodao;

    @GetMapping
    public String listaRepuestos(Model model) {
        model.addAttribute("repuestos", repuestodao.findAll());
        return "listarepuesto";
    }

    @GetMapping("/buscar")
    public String buscarRepuestos(@RequestParam String nombre, Model model) {
        List<Repuesto> repuestos = repuestodao.findByNombreContaining(nombre);
        model.addAttribute("repuestos", repuestos);
        return "listarepuesto";
    }
}
