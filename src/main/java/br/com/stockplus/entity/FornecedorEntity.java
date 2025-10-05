package br.com.stockplus.entity;

import lombok.Data;

@Data
public class FornecedorEntity {
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String email;
    private String endereco;
    private String numeroEndereco;
    private String telefone;
    private String bairroEndereco;
    private String cidade;
    private String uf;

}
