package com.Fideautos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Fideautos.domain.Usuario;
import com.Fideautos.dao.UsuarioDao;

@Controller
public class AutenticacionController {
    @Autowired
    private UsuarioDao usuariodao;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }
    
    @PostMapping("/registro")
    public String registerUser(Usuario usuario) {
        usuario.setContraseña(bCryptPasswordEncoder.encode(usuario.getContraseña()));
        usuario.setRole("USUARIO");
        usuariodao.save(usuario);
        return "redirect:/login";
    }
}
