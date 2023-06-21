package br.com.fiap.pettech.dominio.produto.dto;

import br.com.fiap.pettech.dominio.produto.entitie.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class ProdutoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty
    private UUID id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String descricao;
    @JsonProperty
    private String urlImagem;
    @JsonProperty
    private double preco;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.id();
        this.nome = produto.nome();
        this.descricao = produto.descricao();
        this.urlImagem = produto.urlImagem();
        this.preco = produto.preco();
    }

    public UUID id() {
        return id;
    }

    public ProdutoDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String nome() {
        return nome;
    }

    public ProdutoDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String descricao() {
        return descricao;
    }

    public ProdutoDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String urlImagem() {
        return urlImagem;
    }

    public ProdutoDTO setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
        return this;
    }

    public double preco() {
        return preco;
    }

    public ProdutoDTO setPreco(double preco) {
        this.preco = preco;
        return this;
    }
}
