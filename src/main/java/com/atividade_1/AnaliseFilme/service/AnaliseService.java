package com.atividade_1.AnaliseFilme.service;

import com.atividade_1.AnaliseFilme.model.Analise;
import com.atividade_1.AnaliseFilme.model.AnaliseRepository;
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
    
    public Analise atualizarAnalise(Integer id, Analise analiseAtualizada) 
    {
        Analise analise = getAnaliseById(id);
        analise.setAnalise(analiseAtualizada.getAnalise());
        analise.setFilme(analiseAtualizada.getFilme());
        analise.setNota(analiseAtualizada.getNota());
        
        analiseRepository.save(analise);
        
        return analise;
    }
    
    public Analise getAnaliseById(Integer id) 
    {
        return analiseRepository.findById(id).orElse(null);
    }
    
    public void deletarAnalise(Integer id) 
    {
        Analise analise = getAnaliseById(id);
        analiseRepository.deleteById(analise.getId());
    }
}
