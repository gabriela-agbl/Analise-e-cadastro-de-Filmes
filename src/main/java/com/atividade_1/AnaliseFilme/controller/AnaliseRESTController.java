package com.atividade_1.AnaliseFilme.controller;

import com.atividade_1.AnaliseFilme.model.Analise;
import com.atividade_1.AnaliseFilme.service.AnaliseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/analises")
public class AnaliseRESTController 
{
    @Autowired
    private AnaliseService analiseService; 

    @GetMapping("/")
    public ResponseEntity<List> listarAnalises() 
    {
        List<Analise> analise = analiseService.listarAnalises();
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Analise> adicionarAnalise(@RequestBody Analise analise) 
    {
        var novaAnalise = analiseService.adicionarAnalise(analise);
        
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Integer id, @RequestBody Analise analise) 
    {
        var analiseAtualizada = analiseService.atualizarAnalise(id, analise);
        return new ResponseEntity<>(analiseAtualizada, HttpStatus.OK); 
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity deletarAnalise(@PathVariable Integer id) 
    {
        analiseService.deletarAnalise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
