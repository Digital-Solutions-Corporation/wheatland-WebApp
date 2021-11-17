package com.fiap.wheatland.wheatland.controller;

import com.fiap.wheatland.wheatland.model.Usuario;
import com.fiap.wheatland.wheatland.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/new")
    public String create(Usuario usuario) {
        return "cadastro-usuario";
    }

    @PostMapping("/addUsuario")
    @ApiOperation(value = "Criar um novo usuário.")
    public String addUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) return "cadastro-usuario";
        usuarioService.saveUsuario(usuario, result);
        return "cadastro-usuario";
    }

    @GetMapping("/usuarios")
    @ApiOperation(value = "Listar todos os usuario.")
    public List<Usuario> findAllUsuarios() { return usuarioService.getUsuarios(); }

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Procurar um usuario pelo ID.")
    public Usuario findUsuarioById(@PathVariable int id) { return usuarioService.getUsuarioById(id); }

    @PutMapping("/update")
    @ApiOperation(value = "Atualizar um usuario.")
    public Usuario updateUsuario(@RequestBody Usuario usuario) { return usuarioService.updateUsuario(usuario); }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletar um usuario pelo ID.")
    public String deleteUsuario(@PathVariable int id) { return usuarioService.deleteUsuario(id); }

}
