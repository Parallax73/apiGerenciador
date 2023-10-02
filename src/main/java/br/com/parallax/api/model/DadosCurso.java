package br.com.parallax.api.model;

import br.com.parallax.api.enums.eCurso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCurso(
        @NotBlank
        @Pattern(regexp = "\\d{1,3}")
        String codCurso,
        @NotNull
        eCurso nomeCurso) {

        public String getCodCurso() {
                return codCurso;
        }

        public eCurso getNomeCurso() {
                return nomeCurso;
        }
}
