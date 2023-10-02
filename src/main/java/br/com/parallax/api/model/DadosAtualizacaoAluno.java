package br.com.parallax.api.model;


import br.com.parallax.api.enums.eSituacao;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        eSituacao situacao) {

}
