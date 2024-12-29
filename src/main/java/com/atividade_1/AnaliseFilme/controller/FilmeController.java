package com.atividade_1.AnaliseFilme.controller;

import com.atividade_1.AnaliseFilme.service.FilmeService;
import com.atividade_1.AnaliseFilme.model.Filme;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmeController {

@Autowired
private FilmeService filmeService;

@GetMapping("/")
public String listarFilmes(Model model) 
{
    model.addAttribute("listarFilmes", filmeService.listarFilmes());
    return "listarFilmes";
} 

@GetMapping("/excluir/{id}")
public String deletarFilme(@PathVariable(value = "id") Integer id) 
{
    filmeService.deletarFilme(id);
    return "redirect:/";
} 

@GetMapping("/cadastrar")
public String exibirFormularioCadastro(Model model) 
{
    Filme filme = new Filme();
    model.addAttribute("filme", filme);
    return "cadastrarFilme";
} 

@PostMapping("/cadastrar")
public String cadastrarFilme(@Valid @ModelAttribute("filme") Filme filme, BindingResult result) 
{
    if (result.hasErrors()) 
    {
        return "cadastrarFilme";
    } 
    
    if (filme.getId() == 0) 
    {
        filmeService.cadastrarFilme(filme);
    } 
      
    else 
    { 
        filmeService.atualizarFilme(filme.getId(), filme);
    } 

    return "redirect:/";
    
} 

@GetMapping("/atualizar/{id}")
public String atualizarFilme(@PathVariable(value = "id") Integer id, Model model) 
{
    Filme filme = filmeService.getFilmeById(id);
    model.addAttribute("filme", filme);
    return "atualizarFilme";
} 

}
