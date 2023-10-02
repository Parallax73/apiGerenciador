package br.com.parallax.api.repository;

import br.com.parallax.api.enums.eCurso;
import br.com.parallax.api.model.DadosCurso;
import jakarta.persistence.Embeddable;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {


    private String codCurso;

    @Enumerated(EnumType.STRING) // You need to specify the EnumType
    private eCurso nomeCurso;

    public Curso(DadosCurso dados) {
        this.codCurso = dados.getCodCurso(); // Correct method names
        this.nomeCurso = dados.getNomeCurso(); // Correct method names
    }

}
