package org.serratec.aula06.service;

import org.serratec.aula06.entity.Usuario;
import org.serratec.aula06.exception.NaoEncontradoException;
import org.serratec.aula06.model.UsuarioBuscaId;
import org.serratec.aula06.model.UsuarioCriar;
import org.serratec.aula06.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private String appName;
    private String dbNome;

    public UsuarioService(UsuarioRepository usuarioRepository, @Value("${spring.application.name}") String appName,
                          @Value("${spring.datasource.url}") String dbName) {
        this.usuarioRepository = usuarioRepository;
        this.appName = appName;
        this.dbNome = dbName;
    }

    public void inserir(UsuarioCriar usuario) {
        // mappers
        //        // pessima pratica
        //        Usuario usuarioInserir = new Usuario();
        //        usuarioInserir.setNome(usuario.getNome());
        //        usuarioInserir.setEmail(usuario.getEmail());
        //        usuarioInserir.setSenha(usuario.getSenha());
        //        usuarioInserir.setCpf(usuario.getCpf());
        //        usuarioInserir.setSenha(usuario.getSenha());
        Usuario usuarioInserir = new Usuario(usuario);
        this.usuarioRepository.save(usuarioInserir);
        System.out.println("Consegui inserir o dado no banco " + this.dbNome);
    }

    public UsuarioBuscaId buscarPorId(UUID id) {
        Usuario usuario = this.usuarioRepository
                .findById(id)
                .orElseThrow(() -> new NaoEncontradoException("O usuario não foi encontrado pelo id:" + id));
        return new UsuarioBuscaId(usuario);
        //        if (usuarioOpt.isEmpty()){
        //            throw new NaoEncontradoException("O usuario não foi encontrado pelo id:" + id);
        //        }
    }

    public List<UsuarioBuscaId> buscar(String cpf, String nome) {
        // find all, filtrar na api

        List<Usuario> usuarios = new ArrayList<>();

        // via Service
        if (cpf != null && !cpf.isBlank()) {
            usuarios = this.usuarioRepository.findByCpf(cpf);
        }

        if (nome != null && !nome.isBlank()) {
            usuarios = this.usuarioRepository.findByNome(nome);
        }

        if (usuarios.isEmpty()) {
            throw new NaoEncontradoException("Usuários não encontrados pelos parametros");
        }

        return usuarios
                .stream()
                .map(usuario -> new UsuarioBuscaId(usuario))
                .toList();
        // enriquecer o repository com funções mais avançadas do JPA Query methods
    }

}
