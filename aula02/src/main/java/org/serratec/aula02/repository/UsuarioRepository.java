package org.serratec.aula02.repository;

import org.serratec.aula02.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository // diz ao spring para gerenciar esta interface que é um repositorio
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    // criar sql "dinamicos"
    // select * from usuario_tb where nome like '%?%'
    List<Usuario> findByNomeLike(String nome);

}
