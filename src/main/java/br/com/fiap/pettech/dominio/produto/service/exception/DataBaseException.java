package br.com.fiap.pettech.dominio.produto.service.exception;

public class DataBaseException extends RuntimeException {

    public DataBaseException(String message) {
        super(message);
    }
}
