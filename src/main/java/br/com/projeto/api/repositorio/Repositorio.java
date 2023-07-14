package br.com.projeto.api.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Show;

@Repository
public interface Repositorio extends CrudRepository<Show, Integer> {
    // selecionar todos os shows
    List<Show> findAll();

    // selecionar pelo nome 
    List<Show> findByTitulo(String nome);

    // para remover um show pelo id
    Show findById(String id);

    // ordenar pelo titulo 
    List<Show> findByOrderByTitulo();
    List<Show> findByTipoOrderByTitulo(String tipo);

    List<Show> findByOrderByNota();


    List<Show> findByTituloContaining(String termo);


    List<Show> findByTituloStartsWith(String termo);


    List<Show> findByTituloEndsWith(String termo);


    // selecionar pelo ano(dataLancamento) maior ou igual a 
    @Query(value = "SELECT * FROM Netflix WHERE release_year >= :ano", nativeQuery = true)
    List<Show> showsAnoMaior(int ano);

    // selecionar todos os filmes 
    @Query(value = "SELECT * FROM Netflix WHERE type = :tipo", nativeQuery = true)
    List<Show> Filmes(String tipo);

    @Query(value = "SELECT * FROM Netflix WHERE nota >= :nota", nativeQuery = true)
    List<Show> notaMaiorIgual(int nota);

    int countById(String id);
    int countByTipo(String tipo);

    int countByTitulo(String nome);

    
}
// Funcionalidades: 


// selecionar todos os tv shows

// selecionar pelo ano(dataLanc) maior ou igual a 
// selecionar pela nota maior ou igual a
// cadastrar um show 
// editar um show 


// contador de shows
// contador de filmes 

//- Status: status da API
//- Home
//- Boas-vindas
//- Boas-vindas com Nome
