package com.api.cinema.controller;

import com.api.cinema.data.AnaliseEntity;
import com.api.cinema.data.FilmeEntity;
import com.api.cinema.service.AnaliseService;
import com.api.cinema.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class AnaliseController {
    @Autowired
    private AnaliseService analiseService;
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public String criarAnaliseForm(Model model) {
        FilmeEntity filme = new FilmeEntity();
        model.addAttribute("filme", filme);
        model.addAttribute("analise", new AnaliseEntity());
        return "filmeDetalhe";
    }

    @GetMapping("/")

    @PostMapping("/{id}/analisar")
    public String analisar(@PathVariable("id") Long id, @ModelAttribute("analise") AnaliseEntity analise) {
        FilmeEntity filme = filmeService.obterFilmePorId(id);
        if (filme == null) {
            return "redirect:/";
        }
        analise.setFilme(filme);
        analiseService.criarAnalise(analise);
        return "redirect:/" + id;
    }
}


