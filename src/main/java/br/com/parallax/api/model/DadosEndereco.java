package br.com.parallax.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        @Pattern(regexp = "\\d{1,4}")
        String numero,
        @NotBlank
        String cidade) {
}
