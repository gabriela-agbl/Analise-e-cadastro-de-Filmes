package com.atividade_1.AnaliseFilme.service;

import com.atividade_1.AnaliseFilme.model.Filme;
import com.atividade_1.AnaliseFilme.model.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmeService 
{
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme cadastrarFilme(Filme filme) 
    {
        filme.setId(null);
        
        filmeRepository.save(filme);
        
        return filme;
    }

    public Filme atualizarFilme(Integer id, Filme filmeAtualizado) 
    {
        Filme filme = getFilmeById(id);
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setSinopse(filmeAtualizado.getSinopse());
        
        filmeRepository.save(filme);
        
        return filme;
    }

    public Filme getFilmeById(Integer id) 
    {
        return filmeRepository.findById(id).orElse(null);
    }

    public List<Filme> listarFilmes() 
    {
        return filmeRepository.findAll();
    }

    public void deletarFilme(Integer id) 
    {
        Filme filme = getFilmeById(id);
        filmeRepository.deleteById(filme.getId());
    }
}
