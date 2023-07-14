package br.com.projeto.api.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.modelo.Show;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;
import jakarta.validation.Valid;

@RestController
public class Controle {
    @Autowired
    private Repositorio acao; 

    @Autowired
    private Servico servico;

    // selecionar todos os shows
    @GetMapping("/api")
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();
    }

    // selecionar todos os filmes 
    @GetMapping("/api/filmes")
    public ResponseEntity<?> selecionarFilmes() {
        return servico.selecionarPeloTipo("Movie");
    }

    // selecionar todos os tv shows 
    @GetMapping("/api/tvshows")
    public ResponseEntity<?> selecionarTVShows() {
        return servico.selecionarPeloTipo("TV Show");
    }

    // selecionar pelo nome
    @GetMapping("/api/{nome}")
    public List<Show> selecionar(String nome) {
        return acao.findByTitulo(nome);
    }

    // selecionar pelo ano(dataLanc) maior ou igual a 
    @GetMapping("/api/{ano}")
    public List<Show> selecionarShowsAnoMaior(int ano) {
        return acao.showsAnoMaior(ano);
    }

    // selecionar pela nota maior ou igual a
    // cadastrar um show 
    // editar um show 
    // remover um show (so com autorizacao)
    // ordenar shows pelo nome 
    // contador de shows
    // contador de filmes 
    // contador de tv shows
    //- Status: status da API
    //- Home
    //- Boas-vindas
    //- Boas-vindas com Nome
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Show obj) {
        return servico.cadastrar(obj);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> selecionarPeloId(@PathVariable String id) {
        return servico.selecionarPeloId(id);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Show obj) {
        return servico.editar(obj);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> remover(@PathVariable String id) {
        return servico.remover(id);
    }

    @GetMapping("/api/contador")
    public long contador() {
        return acao.count();
    }

    @GetMapping("/api/odernarNomes")
    public List<Show> ordenarNomes() {
        return acao.findByOrderByTitulo();
    }

    @GetMapping("/api/nomeContem/{termo}") 
    public List<Show> nomeContem(String termo) {
        return acao.findByTituloContaining(termo);
    }

    @GetMapping("/api/iniciaCom/{termo}")
    public List<Show> iniciaCom(String termo) {
        return acao.findByTituloStartsWith(termo);
    }

    @GetMapping("/api/notaMaiorIgual/{nota}")
    public List<Show> notaMaiorIgual(int nota) {
        return acao.notaMaiorIgual(nota);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public String mensagem() {
        return "Hello world!";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Seja bem vindo(a)!";
    }

    @PostMapping("/show")
    public void show(@Valid @RequestBody Show obj){
        
    }

}

// Funcionalidades: 

// selecionar todos os filmes 
// selecionar todos os tv shows
// selecionar pelo nome
// selecionar pelo ano(dataLanc) maior ou igual a 
// selecionar pela nota maior ou igual a
// cadastrar um show 
// editar um show 
// remover um show (so com autorizacao)
// ordenar shows pelo nome 
// contador de shows
// contador de filmes 
// contador de tv shows
//- Status: status da API
//- Home
//- Boas-vindas
//- Boas-vindas com Nome
