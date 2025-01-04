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
    
    @DeleteMapping("/excluir/{id_a}")
    public ResponseEntity deletarAnalise(@PathVariable Integer id_a) 
    {
        analiseService.deletarAnalise(id_a);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
