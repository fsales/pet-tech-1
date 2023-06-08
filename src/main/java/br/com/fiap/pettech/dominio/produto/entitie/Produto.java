package br.com.fiap.pettech.dominio.produto.entitie;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Produto {


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

    public Produto() {
        this.id = UUID.randomUUID();
    }

    public Produto(String nome, String descricao, String urlImagem, double preco) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
        this.preco = preco;
    }

    public UUID id() {
        return id;
    }

    public Produto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String nome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String descricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String urlImagem() {
        return urlImagem;
    }

    public Produto setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
        return this;
    }

    public double preco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                ", preco=" + preco +
                '}';
    }
}
