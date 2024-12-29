package com.atividade_1.AnaliseFilme.controller;

import com.atividade_1.AnaliseFilme.model.Filme;
import com.atividade_1.AnaliseFilme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/filmes")
public class FilmeRESTController 
{
    @Autowired
    private FilmeService filmeService; 

    @GetMapping("/")
    public ResponseEntity<List> listarFilmes() 
    {
        List<Filme> filme = filmeService.listarFilmes();
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) 
    {
        var novoFilme = filmeService.cadastrarFilme(filme);
        
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer id, @RequestBody Filme filme) 
    {
        var filmeAtualizado = filmeService.atualizarFilme(id, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK); 
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id) 
    {
        filmeService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
