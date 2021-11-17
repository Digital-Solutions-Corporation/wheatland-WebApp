package com.fiap.wheatland.wheatland.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ONG")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ong", nullable = false)
    private int id;

    @Size(min = 14, max = 14)
    @Column(name = "cnpj_ong", nullable = false)
    private String cnpj;

    @NotBlank
    @Column(name = "nm_ong", nullable = false)
    private String nome;

    @Column(name = "ds_email_ong", nullable = false)
    private String email;

    @Column(name = "ds_url_foto_ong")
    private String urlFoto;

    @Size(min = 10)
    @Column(name = "ds_ong")
    private String descricao;

}
