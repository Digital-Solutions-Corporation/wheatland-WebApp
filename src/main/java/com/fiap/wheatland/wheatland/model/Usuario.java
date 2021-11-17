package com.fiap.wheatland.wheatland.model;

import com.fiap.wheatland.wheatland.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int id;

    @Size(min = 11, max = 11)
    @Column(name = "cpf_usuario", nullable = false)
    private String cpf;

    @NotBlank
    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "ds_email_usuario", nullable = false)
    private String email;

    @NotBlank
    @Column(name = "ds_senha_usuario", nullable = false)
    private String senha;

    @Column(name = "ds_url_foto_usuario")
    private String urlFoto;

    @Size(min = 2, max = 3)
    @Column(name = "nr_idade_usuario")
    private String idade;

    @Column(name = "ds_genero")
    private Genero genero;

}
