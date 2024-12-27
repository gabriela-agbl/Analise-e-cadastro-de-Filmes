package com.atividade_1.AnaliseFilme.controller;

import com.atividade_1.AnaliseFilme.model.Analise;
import com.atividade_1.AnaliseFilme.model.Filme;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmeController 
{
    private List<Filme> filmes = new ArrayList<>();
    private List<Analise> analises = new ArrayList<>();
    private int analiseIdCounter = 1; // Para gerar IDs únicos para análises

    @GetMapping("/")
    public String listarFilmes(Model model) 
    {
        model.addAttribute("filmes", filmes);
        return "listarFilmes";
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro() 
    {
        return "cadastrarFilme";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFilme(@ModelAttribute Filme filme) 
    {
        filme.setId(filmes.size() + 1); // Define o ID do filme
        filmes.add(filme);
        return "redirect:/";
    }
    
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhes(@PathVariable int id, Model model)
    {
        Filme filme = filmes.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
        
        if(filme == null)
        {
            return "redirect:/";
        }
        
        List<Analise> analisesDoFilme = analises.stream()
                .filter(a -> a.getFilme().getId() == id)
                .toList();
        model.addAttribute("filme", filme);
        model.addAttribute("analises", analisesDoFilme);
        model.addAttribute("novaAnalise", new Analise());
        
        return "detalhesFilme";
    }
    
    @PostMapping("/detalhes/{id}/adicionar-analise")
    public String adicionarAnalise(@PathVariable int id, @ModelAttribute Analise novaAnalise)
    {
        Filme filme = filmes.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
        
        if(filme != null)
        {
            novaAnalise.setId(analiseIdCounter++);
            novaAnalise.setFilme(filme);
            analises.add(novaAnalise);
        }
        
        return "redirect:/detalhes/" + id;
    }
    
}
