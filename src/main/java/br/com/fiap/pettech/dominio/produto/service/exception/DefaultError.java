package br.com.fiap.pettech.dominio.produto.service.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class DefaultError {

    @JsonProperty
    private Instant timestap;

    @JsonProperty
    private Integer status;

    @JsonProperty
    private String erro;

    @JsonProperty
    private String mensagem;

    @JsonProperty
    private String path;

    public DefaultError() {
    }

    public DefaultError(Instant timestap, Integer status, String erro, String mensagem, String path) {
        this.timestap = timestap;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.path = path;
    }

    public Instant timestap() {
        return timestap;
    }

    public DefaultError setTimestap(Instant timestap) {
        this.timestap = timestap;
        return this;
    }

    public Integer status() {
        return status;
    }

    public DefaultError setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String erro() {
        return erro;
    }

    public DefaultError setErro(String erro) {
        this.erro = erro;
        return this;
    }

    public String mensagem() {
        return mensagem;
    }

    public DefaultError setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public String path() {
        return path;
    }

    public DefaultError setPath(String path) {
        this.path = path;
        return this;
    }
}
