package br.com.parallax.api.model;


import br.com.parallax.api.enums.eEstadoCivil;
import br.com.parallax.api.enums.eGenero;
import br.com.parallax.api.enums.eSituacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno (
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{7}")
        String ra,
        @NotNull
        @Valid
        DadosCurso curso,

        @NotNull
        eGenero genero,
        @NotNull
        eEstadoCivil estadoCivil,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String telefone,
        @NotNull
        eSituacao situacao) {
}
