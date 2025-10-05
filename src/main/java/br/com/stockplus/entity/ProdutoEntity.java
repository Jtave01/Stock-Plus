package br.com.stockplus.entity;

import lombok.Data;

import java.util.Date;

@Data

public class ProdutoEntity {
    private Long id;
    private String codIdent;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Double preco;
    private String localizacao;
    private FornecedorEntity fornecedor;
    private Date dataInsercao;
}
