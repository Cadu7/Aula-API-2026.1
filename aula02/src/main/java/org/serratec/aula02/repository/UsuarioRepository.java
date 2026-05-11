package org.serratec.aula02.repository;

import org.serratec.aula02.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // diz ao spring para gerenciar esta interface que é um repositorio
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
