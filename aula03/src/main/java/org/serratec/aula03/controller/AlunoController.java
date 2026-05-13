package org.serratec.aula03.controller;

import org.serratec.aula03.entity.Aluno;
import org.serratec.aula03.model.MensagemResposta;
import org.serratec.aula03.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    @Autowired // faz a instancia da classe/interface (new)
    private AlunoRepository alunoRepository;

    //    @Value("${}")

    @PostMapping()
    public ResponseEntity<MensagemResposta> inserirAlunos(@RequestBody List<Aluno> alunos) {
        this.alunoRepository.saveAll(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensagemResposta("Os alunos foram criados com suceso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemResposta> deletarAluno(@PathVariable UUID id) {
        this.alunoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new MensagemResposta("O aluno foi deletado"));
    }

    @GetMapping// /api/v1/aluno?id=16584164-814681-516168
    public ResponseEntity<Optional<Aluno>> findById(@RequestParam UUID id) {
        Optional<Aluno> response = this.alunoRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualiza(@RequestBody Aluno aluno, @PathVariable UUID id) {
        Optional<Aluno> alunoOpt = this.alunoRepository.findById(id);
        if (alunoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Aluno alunoDB = alunoOpt.get();
        alunoDB.setNome(aluno.getNome());
        alunoDB.setEmail(aluno.getEmail());
        this.alunoRepository.save(alunoDB);
        return ResponseEntity.status(HttpStatus.OK).body(alunoDB);
    }

}
