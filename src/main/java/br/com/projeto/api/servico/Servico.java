package br.com.projeto.api.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.projeto.api.modelo.Mensagem;
import br.com.projeto.api.modelo.Show;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    // método para cadastrar pessoas
    public ResponseEntity<?> cadastrar(Show obj) {
        if(obj.getId() == null){
            mensagem.setMensagem("O id precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } 
        else if(obj.getTitulo().equals("")){
            mensagem.setMensagem("O titulo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

     // método para selecionar pessoas 
     public ResponseEntity<?> selecionar() {
         return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
     }

    //  método para selecionar pessoas pelo nome 
     public ResponseEntity<?> selecionarPeloNome(String nome) {
         if (acao.countByTitulo(nome) == 0) {
             mensagem.setMensagem("Não foi encontrado nenhum registro.");
             return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
         } else {
             return new ResponseEntity<>(acao.findByTitulo(nome), HttpStatus.OK);
         }
     }
 // método para selecionar pessoas pelo id
     public ResponseEntity<?> selecionarPeloId(String id) {
         if (acao.countById(id) == 0) {
             mensagem.setMensagem("Não foi encontrado nenhum registro.");
             return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
         } else {
             return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
         }
     }

      // método para selecionar pessoas pelo id
     public ResponseEntity<?> selecionarPeloTipo(String tipo) {
         if (acao.countByTipo(tipo) == 0) {
             mensagem.setMensagem("Não foi encontrado nenhum registro.");
             return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
         } else {
             return new ResponseEntity<>(acao.findByTipoOrderByTitulo(tipo), HttpStatus.OK);
         }
     }

    //  método para editar dados
     public ResponseEntity<?> editar(Show obj) {
         if(acao.countById(obj.getId()) == 0) {
             mensagem.setMensagem("O id informado não existe.");
             return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
         }
         else if (obj.getTitulo().equals("")){
             mensagem.setMensagem("É necessário informar um título.");
             return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
         } else {
             return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
         }
     }

     public ResponseEntity<?> remover(String id) {
         if (acao.countById(id) == 0) {
             mensagem.setMensagem("O id informado não existe.");
             return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
         } else {
             Show obj = acao.findById(id);
             acao.delete(obj);
             mensagem.setMensagem("Show removido com sucesso. ");
             return new ResponseEntity<>(mensagem, HttpStatus.OK);
         }
     }

}
