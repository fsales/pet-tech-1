package br.com.fiap.pettech.dominio.produto.controller;

import br.com.fiap.pettech.dominio.produto.dto.ProdutoDTO;
import br.com.fiap.pettech.dominio.produto.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0")
            Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10")
            Integer tamanho
    ) {

        PageRequest pageRequest = PageRequest.of(pagina, tamanho);

        var produtos = produtoService.findAll(
                pageRequest
        ).map(
                produto -> new ProdutoDTO(produto)
        );

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id) {
        var produto = produtoService.findById(id);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produto) {

        var produtoSave = produtoService.save(produto);

        var produtoDTO = new ProdutoDTO(produtoSave);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoSave.id())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(
            @PathVariable UUID id,
            @RequestBody ProdutoDTO produto
    ) {
        var p = produtoService.update(id, produto);
        return ResponseEntity.ok(new ProdutoDTO(p.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable UUID id
    ) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
