package com.api.cinema.service;

import com.api.cinema.data.FilmeEntity;
import com.api.cinema.data.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeEntity> listarFilmes() {
        return filmeRepository.findAll();
    }

    public FilmeEntity obterFilmePorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public FilmeEntity criarFilme(FilmeEntity filme) {
        return filmeRepository.save(filme);
    }

    public FilmeEntity atualizarFilme(Long id, FilmeEntity filmeAtualizado) {
        FilmeEntity filmeExistente = filmeRepository.findById(id).orElse(null);
        if (filmeExistente != null) {
            filmeExistente.setTitulo(filmeAtualizado.getTitulo());
            filmeExistente.setSinopse(filmeAtualizado.getSinopse());
            filmeExistente.setGenero(filmeAtualizado.getGenero());
            filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            return filmeRepository.save(filmeExistente);
        }
        return null;
    }

    public boolean deletarFilme(Long id) {
        FilmeEntity filmeExistente = filmeRepository.findById(id).orElse(null);
        if (filmeExistente != null) {
            filmeRepository.delete(filmeExistente);
            return true;
        }
        return false;
    }
}
