package com.fiap.wheatland.wheatland.repository;

import com.fiap.wheatland.wheatland.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
