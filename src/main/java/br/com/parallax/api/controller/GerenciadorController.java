package br.com.parallax.api.controller;


import br.com.parallax.api.model.DadosAtualizacaoAluno;
import br.com.parallax.api.model.DadosCadastroAluno;
import br.com.parallax.api.model.DadosListagemAluno;
import br.com.parallax.api.repository.Aluno;
import br.com.parallax.api.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class GerenciadorController {

    @Autowired
    AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastroAluno(@RequestBody @Valid DadosCadastroAluno data){
        repository.save(new Aluno(data));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar (@PageableDefault(sort = {"nome"})Pageable pageable){
        return repository.findAllByativoTrue(pageable).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.excluir();
    }

}
