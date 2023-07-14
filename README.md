# API-Netflix
A aplicação é uma API que fornece funcionalidades relacionadas ao catálogo da Netflix, incluindo filmes e programas de TV. A API é implementada usando o framework Spring Boot em Java.

## Funcionalidades
#### 1. Selecionar todos os filmes
Endpoint: GET /api/filmes <br/>
Descrição: Retorna todos os filmes presentes no catálogo.
#### 2. Selecionar todos os TV shows
Endpoint: GET /api/tvshows <br/>
Descrição: Retorna todos os programas de TV presentes no catálogo.
#### 3. Selecionar pelo nome
Endpoint: GET /api/{nome} <br/>
Descrição: Retorna os shows que correspondem ao nome fornecido.
#### 4. Selecionar pelo ano de lançamento
Endpoint: GET /api/{ano} <br/>
Descrição: Retorna os shows cujo ano de lançamento é maior ou igual ao valor fornecido.
#### 5. Selecionar pela nota
Endpoint: GET /api/notaMaiorIgual/{nota} <br/>
Descrição: Retorna os shows cuja nota é maior ou igual ao valor fornecido.
#### 6. Cadastrar um show
Endpoint: POST /api <br/>
Descrição: Cadastra um novo show no catálogo. <br/>
Corpo da requisição: Objeto Show contendo os detalhes do show a ser cadastrado.
#### 7. Editar um show
Endpoint: PUT /api <br/>
Descrição: Edita os detalhes de um show existente no catálogo. <br/>
Corpo da requisição: Objeto Show contendo os detalhes atualizados do show.
#### 8. Remover um show
Endpoint: DELETE /api/{id} <br/>
Descrição: Remove um show do catálogo com base no ID fornecido. <br/>
Parâmetro: id - ID do show a ser removido.
#### 9. Ordenar shows pelo nome
Endpoint: GET /api/odernarNomes <br/>
Descrição: Retorna os shows do catálogo ordenados em ordem alfabética pelo título.
#### 10.  Contador de shows
Endpoint: GET /api/contador <br/>
Descrição: Retorna o número total de shows no catálogo.
#### 11.  Contador de filmes
Endpoint: GET /api/filmes/contador <br/>
Descrição: Retorna o número total de filmes no catálogo.
#### 12.  Contador de TV shows
Endpoint: GET /api/tvshows/contador <br/>
Descrição: Retorna o número total de programas de TV no catálogo.
#### 13.  Status da API
Endpoint: GET /status <br/>
Descrição: Retorna o status da API.
Resposta: ResponseEntity com status HTTP 201 (CREATED).
#### 14.  Home
Endpoint: GET /      <br/>
Descrição: Retorna uma mensagem de boas-vindas.
#### 15.  Boas-vindas
Endpoint: GET /boasVindas<br/>
Descrição: Retorna uma mensagem de boas-vindas genérica.
#### 16.  Boas-vindas com Nome
Endpoint: GET /boasVindas/{nome} <br/>
Descrição: Retorna uma mensagem de boas-vindas personalizada com base no nome fornecido.<br/>
Parâmetro: nome - Nome para personalizar a mensagem de boas-vindas.

## Estrutura do Projeto
A aplicação é organizada em pacotes da seguinte maneira:

br.com.projeto.api.controle: Contém os controladores REST que definem os endpoints da API. <br/>
br.com.projeto.api.modelo: Contém as classes de modelo, incluindo a classe Show. <br/>
br.com.projeto.api.repositorio: Contém a interface Repositorio para acesso aos dados. <br/>
br.com.projeto.api.servico: Contém a classe Servico que implementa as funcionalidades da API. <br/>

## Requisitos
A aplicação possui as seguintes dependências:
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
<b> Certifique-se de ter as dependências corretamente configuradas para a execução da aplicação. </b> <br/>