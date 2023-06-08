package br.com.fiap.pettech.dominio.produto.controller;

import br.com.fiap.pettech.dominio.produto.entitie.Produto;
import br.com.fiap.pettech.dominio.produto.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Collection<Produto>> findAll() {

        var produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable UUID id) {
        var produto = produtoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        var produtoSave = produtoService.save(produto);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoSave.id())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(produtoSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Produto>> update(
            @PathVariable UUID id,
            @RequestBody Produto produto
    ) {
        var p = produtoService.update(id, produto);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable UUID id
    ) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
