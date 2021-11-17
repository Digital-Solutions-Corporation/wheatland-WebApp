package com.fiap.wheatland.wheatland.service;

import com.fiap.wheatland.wheatland.model.Usuario;
import com.fiap.wheatland.wheatland.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String saveUsuario(Usuario usuario, BindingResult result) {
        if (result.hasErrors()) return "cadastro-usuario";
        usuarioRepository.save(usuario);
        return "cadastro-usuario";
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public String deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
        return "Usuario removed - " + id;
    }

    public Usuario updateUsuario(Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(usuario.getId()).orElse(usuario);
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setIdade(usuario.getIdade());
        existingUsuario.setNome(usuario.getNome());
        existingUsuario.setSenha(usuario.getSenha());
        existingUsuario.setUrlFoto(usuario.getUrlFoto());
        return usuarioRepository.save(existingUsuario);
    }

}
