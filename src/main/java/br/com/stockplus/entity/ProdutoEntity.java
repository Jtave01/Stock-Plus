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
    private Double totalPreco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodIdent() {
        return codIdent;
    }

    public void setCodIdent(String codIdent) {
        this.codIdent = codIdent;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Double getTotalPreco() {
        return totalPreco;
    }

    public void setTotalPreco(Double totalPreco) {
        this.totalPreco = totalPreco;
    }
}
