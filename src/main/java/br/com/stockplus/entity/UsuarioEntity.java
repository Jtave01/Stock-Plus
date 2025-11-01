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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsaername() {
        return Usaername;
    }

    public void setUsaername(String usaername) {
        Usaername = usaername;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntitty getRole() {
        return role;
    }

    public void setRole(RoleEntitty role) {
        this.role = role;
    }
}
