package br.com.fiap.pettech.dominio.produto.controller.exception;

import br.com.fiap.pettech.dominio.produto.service.exception.ControllerNotFoundException;
import br.com.fiap.pettech.dominio.produto.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHanlder extends ResponseEntityExceptionHandler {

    private final DefaultError defaultError = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> resourceNotFoundException(
            ControllerNotFoundException exception,
            HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND;
        defaultError
                .setTimestap(Instant.now())
                .setStatus(status.value())
                .setErro("Entidade não encontrada")
                .setMensagem(exception.getMessage())
                .setPath(request.getRequestURI());
        return new ResponseEntity<DefaultError>(defaultError, status);
    }

//    @ExceptionHandler(ControllerNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public DefaultError resourceNotFoundException(
//            ControllerNotFoundException exception,
//            HttpServletRequest request) {
//        var status = HttpStatus.NOT_FOUND;
//        defaultError
//                .setTimestap(Instant.now())
//                .setStatus(status.value())
//                .setErro("Entidade não encontrada")
//                .setMensagem(exception.getMessage())
//                .setPath(request.getRequestURI());
//        return defaultError;
//    }
}
