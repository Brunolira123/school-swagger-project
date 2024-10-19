# Habilitando a Documentação de uma API com Springdoc

## Título da Prática
Habilitando a documentação de uma API com Springdoc.

## Objetivos
Configurar e utilizar a documentação de uma API com a biblioteca Springdoc e com o Swagger UI.

## Materiais, Métodos e Ferramentas
- IDE  JetBrains IntelliJ
- Java 17 
- Maven
- PostgreSQL

## Descrição do Projeto
Esta prática tem como objetivo habilitar a documentação de uma API desenvolvida com o framework Spring Boot, utilizando a biblioteca Springdoc. A API gerencia uma tabela de **livros** e suas respectivas **categorias**. A documentação facilita a compreensão da API, melhorando a experiência dos desenvolvedores e clientes.

## Estrutura da API

A API possui os seguintes endpoints relacionados a **livros** e **categorias**:

###  Tabela de Livros
- **Endpoint**: `/livros`
- **Métodos**:
    - `GET /livros`: Retorna uma lista de todos os livros.
    - `GET /livros/{id}`: Retorna os detalhes de um livro específico pelo ID.
    - `POST /livros`: Adiciona um novo livro.
    - `PUT /livros/{id}`: Atualiza um livro existente.
    - `DELETE /livros/{id}`: Remove um livro pelo ID.

