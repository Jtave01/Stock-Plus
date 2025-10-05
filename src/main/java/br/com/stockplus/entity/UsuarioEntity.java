package br.com.stockplus.entity;

import lombok.Data;

@Data
public class UsuarioEntity {
    private Long id;
    private String Usaername;
    private String nome;
    private String email;
    private String password;
    private RoleEntitty role;
}
