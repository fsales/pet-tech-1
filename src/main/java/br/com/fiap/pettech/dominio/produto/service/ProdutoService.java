package br.com.fiap.pettech.dominio.produto.service;

import br.com.fiap.pettech.dominio.produto.entitie.Produto;
import br.com.fiap.pettech.dominio.produto.repository.IProdutoRepository;
import br.com.fiap.pettech.dominio.produto.service.exception.ControllerNotFoundException;
import br.com.fiap.pettech.dominio.produto.service.exception.DataBaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    private final IProdutoRepository produtoRepository;

    public ProdutoService(
            IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Collection<Produto> findAll() {
        var lista = produtoRepository.findAll();
        return lista;
    }

    public Produto findById(UUID id) {
        var produto = produtoRepository
                .findById(
                        id
                )
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto não encontrado")
                );
        return produto;
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> update(UUID id, Produto produto) {

        try {
            var produtoExistente = this.findById(id);


            var prod = produtoExistente
                    .setDescricao(produto.descricao())
                    .setUrlImagem(produto.urlImagem())
                    .setPreco(produto.preco())
                    .setNome(produto.nome());
            var produtoUpdate = produtoRepository.save(prod);

            return Optional.of(produtoUpdate);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Produto não encontrado" + " Id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            produtoRepository.deleteById(id);
        } catch (
                EmptyResultDataAccessException |
                DataIntegrityViolationException exception
        ) {
            throw new DataBaseException("Erro ao remover produto. Id: " + id);
        }
    }
}
