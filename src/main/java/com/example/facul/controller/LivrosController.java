package com.example.facul.controller;

import com.example.facul.dto.LivrosDTO;
import com.example.facul.service.LivrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livros", description = "Gerenciamento de livros")
public class LivrosController {

    @Autowired
    private LivrosService service;

    @GetMapping
    @Operation(summary = "Listar todos os livros",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de livros retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            })
    public ResponseEntity<List<LivrosDTO>> findAll() {
        List<LivrosDTO> livros = service.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Livro encontrado"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
            })
    public ResponseEntity<LivrosDTO> findById(@PathVariable Integer id) {
        LivrosDTO livro = service.findById(id);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar livro existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro na solicitação"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
            })
    public ResponseEntity<LivrosDTO> update(@PathVariable Integer id, @RequestBody LivrosDTO livros) {
        LivrosDTO livro = service.findById(id);
        if (livro != null) {
            service.update(id, livros);
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar livro por ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
            })
    public ResponseEntity<LivrosDTO> delete(@PathVariable Integer id) {
        LivrosDTO livro = service.findById(id);
        if (livro != null) {
            service.delete(id);
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
