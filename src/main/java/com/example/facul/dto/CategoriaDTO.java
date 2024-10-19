package com.example.facul.dto;

import com.example.facul.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    private Integer id;
    private String descricao;

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.descricao = categoria.getDescricao();
    }
}
