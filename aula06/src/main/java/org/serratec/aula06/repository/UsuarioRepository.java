package org.serratec.aula06.repository;

import org.serratec.aula06.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    // select * from usuario where cpf = $1
    List<Usuario> findByCpf(String cpf);

    List<Usuario> findByNome(String nome);

}
