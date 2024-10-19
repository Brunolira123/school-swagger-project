package com.example.facul.service;

import com.example.facul.dto.CategoriaDTO;
import com.example.facul.entity.Categoria;
import com.example.facul.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<CategoriaDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public CategoriaDTO findById(Integer id){
        return repository.findById(id)
                .map(CategoriaDTO::new)
                .orElse(null);
    }

    public CategoriaDTO update(Integer id, CategoriaDTO categoria){
        Categoria categoriaEncontrada = new Categoria();
        categoriaEncontrada = repository.findById(id).orElse(null);
        if(categoria != null){
            categoriaEncontrada.setDescricao(categoria.getDescricao());
        }else{
            return null;
        }
        return categoria;
    }
}
