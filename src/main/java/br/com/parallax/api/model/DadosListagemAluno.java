package br.com.parallax.api.model;

import br.com.parallax.api.enums.eEstadoCivil;
import br.com.parallax.api.enums.eGenero;
import br.com.parallax.api.enums.eSituacao;
import br.com.parallax.api.repository.Aluno;
import br.com.parallax.api.repository.Curso;
import br.com.parallax.api.repository.Endereco;

public record DadosListagemAluno(Long id,
                                 String nome, String ra,
                                 Curso curso, eGenero e_genero,
                                 String nome_curso, String cod_Curso,
                                 eEstadoCivil e_estado_Civil,
                                 Endereco endereco, String email,
                                 String telefone,eSituacao esituacao) {

    public DadosListagemAluno(Aluno aluno){
        this(   aluno.getId(),
                aluno.getNome(),
                aluno.getRa(),
                aluno.getCurso(),
                aluno.getEGenero(),
                String.valueOf(aluno.getCurso().getNomeCurso()),
                aluno.getCurso().getCodCurso(),
                aluno.getEEstadoCivil(),
                aluno.getEndereco(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getESituacao());

    }
}
