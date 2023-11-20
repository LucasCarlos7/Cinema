package com.api.cinema.controller;

import com.api.cinema.data.FilmeEntity;
import com.api.cinema.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listarFilmes", filmeService.listarFilmes());
        return "index";
    }

    @GetMapping("/deletarFilme/{id}")
    public String deletarFilme(@PathVariable(value = "id") Long id) {
        filmeService.deletarFilme(id);
        return "redirect:/";
    }

    @GetMapping("/criarFilmeForm")
    public String criarFilmeForm(Model model) {
        FilmeEntity filme = new FilmeEntity();
        model.addAttribute("filme", filme);
        return "inserir";
    }

    @PostMapping("/salvarFilme")
    public String salvarFilme(@ModelAttribute("filme") FilmeEntity filme, BindingResult result) {
        if (result.hasErrors()) {
            return "inserir";
        }
        if (filme.getId() == null) {
            filmeService.criarFilme(filme);
        } else {
            filmeService.atualizarFilme(filme.getId(), filme);
        }
        return "redirect:/";
    }
    
    @GetMapping("/atualizarFilmeForm/{id}")
    public String atualizarFilmeForm(@PathVariable(value="id") Long id, Model model) {
        FilmeEntity filme = filmeService.obterFilmePorId(id);
        model.addAttribute("filme", filme);
        return "atualizar";
    }
}
