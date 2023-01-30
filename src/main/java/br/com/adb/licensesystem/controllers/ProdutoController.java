package br.com.adb.licensesystem.controllers;

import br.com.adb.licensesystem.model.entities.Produto;
import br.com.adb.licensesystem.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto novoProduto(@RequestBody Produto p){
        //Produto produto = new Produto(nome);
        produtoRepository.save(p);
        return p;
    }

    @GetMapping(path = "/produtos")
    public Iterable<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/produtos2")
    public Iterable<Produto> getProdutosDois(){
        return produtoRepository.getProdutos2();
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> getProduto(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @PutMapping
    public Produto atualizaProduto(@Validated @RequestBody Produto produto){
        produtoRepository.save(produto);
        return produto;
    }
}
