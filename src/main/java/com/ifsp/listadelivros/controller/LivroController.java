package com.ifsp.listadelivros.controller;

import java.util.List;
import java.util.Optional;

import com.ifsp.listadelivros.model.Livro;
import com.ifsp.listadelivros.model.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/livros")
@RestController
public class LivroController {
    
    @Autowired
    private LivroRepository lr;

    //? Exibe todos os livros
    @GetMapping("/listagem-livros")
    public List<Livro> getLivros(){
        return (List<Livro>) lr.findAll();
    }

    //? Cria um livro
    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro saveLivro(@RequestBody Livro livro) {
        lr.save(livro);
          if(lr.findById(livro.getId()).isPresent())
              return livro;
        return null;
    }

    //? Deleta um livro
    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Long id){
        lr.deleteById(id);
    }

    //? Atualiza um livro
    @PutMapping("/atualizar/{id}")
    public Livro updateLivro(@RequestBody Livro novoLivro, @PathVariable Long id){
        lr.findById(id).get().getCategorias().forEach(t->t.setLivro(null));
        novoLivro.setId(id);
        novoLivro.getCategorias().forEach(t->t.setLivro(novoLivro));
        return lr.save(novoLivro);
    }

    //? Retorna o livro pelo ID
    @GetMapping("listagem-livros/{id}")
    public Optional<Livro> getLivroById(@PathVariable Long id){
        return lr.findById(id);
    } 
}