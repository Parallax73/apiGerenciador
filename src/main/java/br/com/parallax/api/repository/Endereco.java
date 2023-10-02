package br.com.parallax.api.repository;

import br.com.parallax.api.model.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String cidade;

    public Endereco(DadosEndereco dados){

        this.logradouro=dados.logradouro();
        this.numero=dados.numero();
        this.cidade=dados.cidade();

    }
}
