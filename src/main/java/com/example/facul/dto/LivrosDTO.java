package com.example.facul.dto;


import com.example.facul.entity.Livros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosDTO {

    private Integer id;
    private String nome;
    private LocalDate dataLancamento;
    private CategoriaDTO categoriaDTO;

    public LivrosDTO(Livros livros) {
        this.id = livros.getId();
        this.nome = livros.getNome();
        this.dataLancamento = livros.getDataLancamento();
        this.categoriaDTO = new CategoriaDTO(livros.getCategoria());
    }
}
