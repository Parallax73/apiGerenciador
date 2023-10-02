package br.com.parallax.api.repository;

import br.com.parallax.api.enums.eEstadoCivil;
import br.com.parallax.api.enums.eGenero;
import br.com.parallax.api.enums.eSituacao;
import br.com.parallax.api.model.DadosAtualizacaoAluno;
import br.com.parallax.api.model.DadosCadastroAluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String ra;
    private String email;
    private String telefone;


    @Enumerated(EnumType.STRING)
    private eGenero eGenero;

    @Enumerated(EnumType.STRING)
    private eEstadoCivil eEstadoCivil;

    @Enumerated(EnumType.STRING)
    private eSituacao eSituacao;

    @Embedded
    private Curso curso;

    @Embedded
    private Endereco endereco;


    private boolean ativo;

    public Aluno(DadosCadastroAluno dados){
        this.ativo = true;
        this.nome=dados.nome();
        this.ra=dados.ra();
        this.email=dados.email();
        this.eGenero =dados.genero();
        this.eEstadoCivil =dados.estadoCivil();
        this.eSituacao =dados.situacao();
        this.telefone= dados.telefone();
        this.curso= new Curso(dados.curso());
        this.endereco= new Endereco(dados.endereco());

    }

    public void atualizarInfo(DadosAtualizacaoAluno dados){
        if (dados.situacao()!=null){
            this.eSituacao=dados.situacao();
        }
    }

    public void excluir(){
        this.ativo=false;
        this.eSituacao= br.com.parallax.api.enums.eSituacao.valueOf("CANCELADA");
    }

}
