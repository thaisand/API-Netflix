package br.com.projeto.api.modelo;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Netflix")
public class Show {
    @Id
    @NotEmpty(message = "Informe um Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private String id;

    @Column(name = "title")
    @NotEmpty(message = "Informe um título")
    private String titulo;
    
    @Column(name = "type")
    private String tipo;
    
    @Column(name = "director")
    private String diretor;
       
    @Column(name = "cast")
    private String elenco; 
    
    @Column(name = "country")
    private String pais;
     
    @Column(name = "date_added")
    private Date  dataAdicao;

    @Column(name = "release_year")
    private int dataLancamento; 

    @Column(name = "rating")
    private String nota;

    @Column(name = "duration")
    private String duracao;
    
    @Column(name = "genres")
    private String generos; 

    @Column(name = "description")
    private String descricao;
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }   

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }   

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }    

    public Date  getDataAdicao() {
        return dataAdicao;
    }

    public void setDataAdicao(Date dataAdicao) {
        this.dataAdicao = dataAdicao;
    }    

    public int getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(int dataLancamento) {
        this.dataLancamento = dataLancamento;
    }    

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }    

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }   

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}


