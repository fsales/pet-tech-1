package br.com.fiap.pettech.dominio.produto.repository;

import br.com.fiap.pettech.dominio.produto.entitie.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProdutoRepositoryOld implements IProdutoRepositoryOld {

    private static Set<Produto> produtos;

    static {
        produtos = new LinkedHashSet<>();

        Produto produto1 = new Produto(
                "produto 1",
                "Descrição  produto 1",
                "http://",
                122.2
        );

        Produto produto2 = new Produto(
                "produto 2",
                "Descrição produto 2",
                "http://",
                152.2
        );

        produtos.add(produto1);
        produtos.add(produto2);
    }

    @Override
    public Optional<Produto> findById(UUID id) {
        var produto = produtos
                .stream()
                .filter(
                        p -> p.id().equals(id)
                )
                .findFirst();

        return produto;
    }

    @Override
    public Set<Produto> findall() {
        return Collections
                .unmodifiableSet(
                        produtos
                );
    }

    @Override
    public Produto save(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @Override
    public Produto update(UUID id, Produto produto) {

        var produtoBuscado = produtos
                .stream()
                .filter(
                        p -> p.id().equals(id)
                )
                .findFirst()
                .get();

        produtoBuscado
                .setNome(
                        produto.nome()
                )
                .setDescricao(
                        produto.descricao()
                )
                .setPreco(
                        produto.preco()
                )
                .setUrlImagem(
                        produto.urlImagem()
                );

        produtos.add(produtoBuscado);
        return produto;
    }

    @Override
    public void delete(UUID id) {
        produtos.removeIf(p -> p.id().equals(id));
    }
}
