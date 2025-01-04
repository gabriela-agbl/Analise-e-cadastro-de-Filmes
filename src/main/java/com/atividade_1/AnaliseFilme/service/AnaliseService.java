package com.atividade_1.AnaliseFilme.service;

import com.atividade_1.AnaliseFilme.model.Analise;
import com.atividade_1.AnaliseFilme.model.AnaliseRepository;
import com.atividade_1.AnaliseFilme.model.Filme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService 
{
    @Autowired
    private AnaliseRepository analiseRepository;

    public Analise adicionarAnalise(Analise analise) 
    {
        analise.setId(null);
        
        analiseRepository.save(analise);
        
        return analise;
    }

    public List<Analise> listarAnalises() 
    {
        return analiseRepository.findAll();
    }
   
    public Analise getAnaliseById(Integer id_a) 
    {
        return analiseRepository.findById(id_a).orElse(null);
    }
    
    public List<Analise> getAnalisesByFilme(Filme filme) 
    {
        return analiseRepository.findByFilme(filme);
    }
    
    public void deletarAnalise(Integer id_a) 
    {
        Analise analise = getAnaliseById(id_a);
        analiseRepository.deleteById(analise.getId());
    }
}
