package com.labisistemas.gestaofinanceiraapi.controller;

import com.labisistemas.gestaofinanceiraapi.model.Usuario;
import com.labisistemas.gestaofinanceiraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criar() {
        Usuario usuario = new Usuario("João");
        usuarioRepository.save(usuario);
        return ResponseEntity.created(URI.create("http://localhost:8080/usuarios" + usuario.getId())).build();
    }
}
