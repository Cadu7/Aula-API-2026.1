package org.serratec.aula03.repository;

import org.serratec.aula03.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

    // named query de vdd
//    void removeByMatricula(String matricula);

}
