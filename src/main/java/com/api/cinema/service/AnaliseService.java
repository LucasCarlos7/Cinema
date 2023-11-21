package com.api.cinema.service;

import com.api.cinema.data.AnaliseEntity;
import com.api.cinema.data.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    @Autowired
    private AnaliseRepository analiseRepository;

    public List<AnaliseEntity> listarAnalises() {
        return analiseRepository.findAll();
    }

    public List<AnaliseEntity> listarAnalisesPorFilme(Long filmeId) {
        return analiseRepository.findByFilmeId(filmeId);
    }

    public AnaliseEntity criarAnalise(AnaliseEntity analise) {
        return analiseRepository.save(analise);
    }

    public AnaliseEntity atualizarAnalise(Long id, AnaliseEntity analiseAtualizada) {
        AnaliseEntity analiseExistente = analiseRepository.findById(id).orElse(null);
        if (analiseExistente != null) {
            analiseExistente.setTextoAnalise(analiseAtualizada.getTextoAnalise());
            analiseExistente.setNota(analiseAtualizada.getNota());
            return analiseRepository.save(analiseExistente);
        }
        return null;
    }

    public boolean deletarAnalise(Long id) {
        AnaliseEntity analiseExistente = analiseRepository.findById(id).orElse(null);
        if (analiseExistente != null) {
            analiseRepository.delete(analiseExistente);
            return true;
        }
        return false;
    }
}

