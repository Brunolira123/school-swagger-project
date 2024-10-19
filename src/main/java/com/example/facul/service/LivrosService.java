package com.example.facul.service;

import com.example.facul.dto.LivrosDTO;
import com.example.facul.entity.Livros;
import com.example.facul.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository repository;


    public List<LivrosDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(LivrosDTO::new)
                .collect(Collectors.toList());
    }

    public LivrosDTO findById(Integer id) {
        return repository.findById(id)
                .map(LivrosDTO::new)
                .orElse(null);
    }

    public LivrosDTO update(Integer id, LivrosDTO dto) {
        Livros livros = repository.findById(id).orElse(null);
        if (livros == null) {
            return null;
        } else {
            livros.setNome(dto.getNome());
            livros.setDataLancamento(dto.getDataLancamento());
        }
        return dto;
    }

    public Boolean delete(Integer id) {
        Livros  livros = repository.findById(id).orElse(null);
        if (livros != null) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

