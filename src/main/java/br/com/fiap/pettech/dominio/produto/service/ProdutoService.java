package br.com.fiap.pettech.dominio.produto.service;

import br.com.fiap.pettech.dominio.produto.entitie.Produto;
import br.com.fiap.pettech.dominio.produto.repository.IProdutoRepository;
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

    public Optional<Produto> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> update(UUID id, Produto produto) {
        var produtoExistente = this.findById(id);

//        if(produtoExistente.isPresent()){
//            var produtoUpdate = produtoRepository.update(id, produto);
//
//            return Optional.of(produtoUpdate);
//        }

        return Optional.empty();
    }

    public void delete(UUID id) {
//        produtoRepository.delete(id);
    }
}
