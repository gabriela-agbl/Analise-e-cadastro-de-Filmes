package com.atividade_1.AnaliseFilme.controller;

import com.atividade_1.AnaliseFilme.model.Analise;
import com.atividade_1.AnaliseFilme.service.FilmeService;
import com.atividade_1.AnaliseFilme.model.Filme;
import com.atividade_1.AnaliseFilme.model.Preferencia;
import com.atividade_1.AnaliseFilme.service.AnaliseService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmeController {

@Autowired
private FilmeService filmeService;

@Autowired
private AnaliseService analiseService;

@PostMapping("/preferencias")
public ModelAndView gravaPreferencias(@ModelAttribute Preferencia pref, HttpServletResponse response)
{
   Cookie cookiePrefEstilo = new Cookie("pref-estilo", pref.getEstilo()); 
   cookiePrefEstilo.setDomain("localhost"); //disponível apenas no domínio "localhost" 
   cookiePrefEstilo.setHttpOnly(true); //acessível apenas por HTTP, JS não 
   cookiePrefEstilo.setMaxAge(86400); //1 dia 
   response.addCookie(cookiePrefEstilo); 
   
   return new ModelAndView("redirect:/");
}
@GetMapping("/")
public String listarFilmes(@CookieValue(name="pref-estilo", defaultValue="claro")String tema, Model model) 
{
    model.addAttribute("css", tema);
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
    
    if (filme.getId() == null) 
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

@GetMapping("/detalhes/{id}")
public String detalhesFilme(@PathVariable(value = "id") Integer id, Model model) 
{
    Filme filme = filmeService.getFilmeById(id);
    model.addAttribute("filme", filme);
    List<Analise> analises = analiseService.getAnalisesByFilme(filme);
    model.addAttribute("analises", analises); // Formulário para nova análise
    
    return "detalhesFilme";
}

@PostMapping("/detalhes/{id}/adicionar-analise")
public String cadastrarAnalise(@PathVariable(value = "id") Integer id, @ModelAttribute("novaAnalise") Analise novaAnalise) 
{
    Filme filme = filmeService.getFilmeById(id);
    novaAnalise.setFilme(filme);
    analiseService.adicionarAnalise(novaAnalise);
    return "redirect:/detalhes/" + id;
}

@PostMapping("/detalhes/{id}/excluir-analise/{id_a}")
public String excluirAnalise(Model model, @PathVariable(value = "id_a") Integer id_a, @PathVariable(value = "id") Integer id) 
{
    analiseService.deletarAnalise(id_a);
    return "redirect:/detalhes/" + id;
}

}
